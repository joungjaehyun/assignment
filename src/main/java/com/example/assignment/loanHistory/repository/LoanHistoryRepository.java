package com.example.assignment.loanHistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.loanHistory.entity.LoanHistory;

public interface LoanHistoryRepository extends JpaRepository<LoanHistory, Long> {
    List<LoanHistory> findByBookTitle(String bookTitle);

    List<LoanHistory> findByBookTitleAndReturnDateIsNull(String bookTitle);
}
