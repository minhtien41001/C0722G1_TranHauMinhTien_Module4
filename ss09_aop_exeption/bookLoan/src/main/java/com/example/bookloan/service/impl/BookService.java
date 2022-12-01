package com.example.bookloan.service.impl;

import com.example.bookloan.model.Book;
import com.example.bookloan.repository.IBookRepository;
import com.example.bookloan.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Page<Book> searchByTitle(String title, Pageable pageable) {
        return null;
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void update(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(int id) {
        iBookRepository.deleteById(id);
    }
}
