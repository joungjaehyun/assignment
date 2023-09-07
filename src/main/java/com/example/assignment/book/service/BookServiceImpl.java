package com.example.assignment.book.service;

import org.springframework.stereotype.Service;

import com.example.assignment.book.dto.BookDTO;
import com.example.assignment.book.entity.Book;
import com.example.assignment.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    
    private final BookRepository bookRepository;
    
    @Override
    public void registerBook(BookDTO bookDTO) {
    
        Book book = Book.builder()
        .author(bookDTO.getAuthor())
        .title(bookDTO.getTitle())
        .availableForLoan(bookDTO.isAvailableForLoan())
        .build();

        bookRepository.save(book);
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
       
        Book result = bookRepository.findByTitle(bookDTO.getTitle());
        
        result.changeAuthor(bookDTO.getAuthor());
        result.changeTitle(bookDTO.getTitle());
        result.changeAvailableForLoan(bookDTO.isAvailableForLoan());

        bookRepository.save(result);
    }
    
}
