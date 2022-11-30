package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Page<Blog> searchByTitle(String title, Pageable pageable);

    Blog findById(int id);

    void update(Blog blog);

    void remove(int id);
}


