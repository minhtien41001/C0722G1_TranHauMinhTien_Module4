package com.example.bookloan.repository;

import com.example.bookloan.model.Book;
import com.example.bookloan.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Book findById(int id);
}
