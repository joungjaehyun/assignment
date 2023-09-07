package com.example.assignment.loanHistory.entity;

import java.util.Date;

import com.example.assignment.account.entity.Account;
import com.example.assignment.book.entity.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_loan_history")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Book book;
    private Date loanDate;
    private Date returnDate;
}
