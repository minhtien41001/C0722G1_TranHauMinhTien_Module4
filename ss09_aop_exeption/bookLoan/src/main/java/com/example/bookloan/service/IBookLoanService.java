package com.example.bookloan.service;

import com.example.bookloan.model.BookLoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookLoanService {
    Page<BookLoan> findAll(Pageable pageable);

    List<BookLoan> findAllList();

    void save(BookLoan bookLoan);

    BookLoan findByCode(String code);

    void update(BookLoan bookLoan);

    void remove(int id);
}
