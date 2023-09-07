package com.example.assignment.loanHistory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.loanHistory.dto.LoanHistoryDTO;
import com.example.assignment.loanHistory.service.LoanHistoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/history/")
public class LoanHistoryController {
    
    private final LoanHistoryService service;


    @PostMapping("/addLoanHistory")
    public void addLoanHistory(@RequestBody LoanHistoryDTO loanHistoryDTO) {
        service.addLoanHistory(loanHistoryDTO);
    }

    @GetMapping("/loanHistory/{bookTitle}")
    public List<LoanHistoryDTO> getLoanHistoryByBookTitle(@PathVariable String bookTitle) {
        return service.getLoanHistoryByBookTitle(bookTitle);
    }
    @PostMapping("/returnBooksByTitle")
    public void returnBooksByTitle(@RequestParam String bookTitle) {
        service.returnBooksByBookTitle(bookTitle);
    }

}
