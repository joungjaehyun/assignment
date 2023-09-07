package com.example.assignment.book.service;

import com.example.assignment.book.dto.BookDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface BookService {
    void registerBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);
}
