package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
   @Autowired
    private IUserService iUserService;

   @GetMapping("")
    public String showList(Model model){
      model.addAttribute("userList",iUserService.findAll());
      return "user/list";
   }

   @GetMapping("/create")
    public String create(Model model){
       model.addAttribute("userDto",new UserDto());
       return "user/create";
   }

   @PostMapping("/save")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
       new UserDto().validate(userDto,bindingResult);
       if (bindingResult.hasFieldErrors()){
           return "user/create";
       }
       else {
           User user = new User();
           BeanUtils.copyProperties(userDto,user);
           iUserService.save(user);
           redirectAttributes.addFlashAttribute("mess","Add new User successful!!");
       }
       return "redirect:/user";
   }
}
