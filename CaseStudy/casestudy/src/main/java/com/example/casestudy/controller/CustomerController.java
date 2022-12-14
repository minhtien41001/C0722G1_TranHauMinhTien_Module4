package com.example.casestudy.controller;

import com.example.casestudy.dto.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch" ,defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch",defaultValue = "") String emailSearch,
                           @RequestParam(value = "customerType",defaultValue = "") String customerType,
                           Model model){
            model.addAttribute("listCustomer",iCustomerService.searchCustomer1(nameSearch,emailSearch,customerType,pageable));
            model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
            model.addAttribute("nameSearch",nameSearch);
            model.addAttribute("emailSearch",emailSearch);
            model.addAttribute("customerType",customerType);
            return "customer/list";
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            iCustomerService.save(customer);
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCustomer( @PathVariable int id,Model model){
        model.addAttribute("customerDto",iCustomerService.findById(id));
        model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("listCustomerType",iCustomerTypeService.findAll());
            return "customer/edit";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            iCustomerService.save(customer);
            return "redirect:/customer/list";
        }
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(value = "idDelete") Integer id){
        iCustomerService.delete(id);
        return "redirect:/customer/list";
    }
}
