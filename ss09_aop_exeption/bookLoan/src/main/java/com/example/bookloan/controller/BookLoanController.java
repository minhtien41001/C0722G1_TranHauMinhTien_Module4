package com.example.bookloan.controller;

import com.example.bookloan.model.BookLoan;
import com.example.bookloan.service.IBookLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookLoanController {
    @Autowired
    private IBookLoanService iBookLoanService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(page = 0,size = 3) Pageable pageable){
        Page<BookLoan> bookLoans =iBookLoanService.findAll(pageable);
        model.addAttribute("bookLoans",bookLoans);
        return "bookLoan/list";
    }

}
