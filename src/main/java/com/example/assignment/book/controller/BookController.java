package com.example.assignment.book.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.book.dto.BookDTO;
import com.example.assignment.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    
    private final BookService service;

     @PostMapping("/registerBook")
    public void register(@RequestBody BookDTO book) {
        service.registerBook(book);
    }

     @PutMapping("/{id}")
    public void updateBook(@RequestBody BookDTO book) {

        service.updateBook(book);
    }
}
