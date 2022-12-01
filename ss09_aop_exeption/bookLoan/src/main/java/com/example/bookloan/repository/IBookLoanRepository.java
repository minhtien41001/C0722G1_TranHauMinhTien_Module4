package com.example.bookloan.repository;

import com.example.bookloan.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookLoanRepository extends JpaRepository<BookLoan, Integer> {
    BookLoan findByCode(String code);
}
