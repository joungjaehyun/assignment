package com.example.assignment.loanHistory.service;

import java.util.List;

import com.example.assignment.loanHistory.dto.LoanHistoryDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface LoanHistoryService {
    void addLoanHistory(LoanHistoryDTO loanHistoryDTO);

    List<LoanHistoryDTO> getLoanHistoryByBookTitle(String bookTitle);

    void returnBooksByBookTitle(String bookTitle);
}
