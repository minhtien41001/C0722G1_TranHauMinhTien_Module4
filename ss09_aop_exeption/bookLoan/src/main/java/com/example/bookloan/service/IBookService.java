package com.example.bookloan.service;

import com.example.bookloan.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Page<Book> searchByTitle(String title, Pageable pageable);

    Book findById(int id);

    void update(Book book);

    void remove(int id);
}
