package com.example.assignment.loanHistory.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanHistoryDTO {
    private String userEmail;
    private String bookTitle;
    private Date loanDate;
    private Date returnDate;
}
