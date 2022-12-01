package com.example.bookloan.service.impl;

import com.example.bookloan.model.BookLoan;
import com.example.bookloan.repository.IBookLoanRepository;
import com.example.bookloan.service.IBookLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookLoanService implements IBookLoanService {
    @Autowired
    IBookLoanRepository iBookLoanRepository;


    @Override
    public Page<BookLoan> findAll(Pageable pageable) {
        return iBookLoanRepository.findAll(pageable);
    }

    @Override
    public List<BookLoan> findAllList() {
        return iBookLoanRepository.findAll();
    }

    @Override
    public void save(BookLoan bookLoan) {
        iBookLoanRepository.save(bookLoan);
    }

    @Override
    public BookLoan findByCode(String code) {
        return iBookLoanRepository.findByCode(code);
    }

    @Override
    public void update(BookLoan bookLoan) {
        iBookLoanRepository.save(bookLoan);
    }

    @Override
    public void remove(int id) {
        iBookLoanRepository.deleteById(id);
    }
}
