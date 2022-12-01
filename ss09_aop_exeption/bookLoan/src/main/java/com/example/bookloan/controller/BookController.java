package com.example.bookloan.controller;

import com.example.bookloan.exception.OutOfBookException;
import com.example.bookloan.model.Book;
import com.example.bookloan.service.IBookLoanService;
import com.example.bookloan.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBookLoanService iBookLoanService;

    @GetMapping("")
    public String showList(@PageableDefault(page = 0,size = 2) Model model, Pageable pageable){
        model.addAttribute("bookList",iBookService.findAll(pageable));
        return "bookLoan/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("book",iBookService.findById(id));
        return "bookLoan/view";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id,Model model) throws OutOfBookException {
        Book book = iBookService.findById(id);
        if (book.getAmount()==0){
            throw new OutOfBookException();
        }else {
            book.setAmount(book.getAmount()-1);
            iBookService.save(book);
            return "redirect:/book";
        }
    }

    @ExceptionHandler(OutOfBookException.class)
    public String OutOfBook(){
        return "book/outOfBook";
    }

}
