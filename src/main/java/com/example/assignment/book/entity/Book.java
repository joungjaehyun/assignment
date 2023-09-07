package com.example.assignment.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Table(name = "tbl_book")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    @Column(columnDefinition = "default 0")
    private boolean availableForLoan = true;


    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeAuthor(String author){
        this.author = author;
    }

    public void changeAvailableForLoan(boolean availableForLoan){
        this.availableForLoan = availableForLoan;
    }
}
