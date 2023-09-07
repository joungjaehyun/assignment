package com.example.assignment.loanHistory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment.account.entity.Account;
import com.example.assignment.account.repository.AccountRepository;
import com.example.assignment.book.entity.Book;
import com.example.assignment.book.repository.BookRepository;
import com.example.assignment.loanHistory.dto.LoanHistoryDTO;
import com.example.assignment.loanHistory.entity.LoanHistory;
import com.example.assignment.loanHistory.repository.LoanHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanHistoryServiceImpl implements LoanHistoryService {

    private final LoanHistoryRepository loanHistoryRepository;
    private final AccountRepository accountRepository;
    private final BookRepository bookRepository;

    // 아이디를 입력 후 도서에 대한 대출처리를 한다 책제목+ id를 통하여 한다
    @Override
    public void addLoanHistory(LoanHistoryDTO loanHistoryDTO) {

        String user = loanHistoryDTO.getUserEmail();
        String title = loanHistoryDTO.getBookTitle();
        Account account = accountRepository.findByEmail(user);
        Book book = bookRepository.findByTitle(title);

        LoanHistory history = LoanHistory.builder()
                .account(account)
                .book(book)
                .loanDate(loanHistoryDTO.getLoanDate())
                .returnDate(loanHistoryDTO.getReturnDate())
                .build();

        loanHistoryRepository.save(history);

    }

    // 등록된 도서에 대한 대출이력을 확인한다 -- 책제목을 통해서 확인
    @Override
    public List<LoanHistoryDTO> getLoanHistoryByBookTitle(String bookTitle) {
        List<LoanHistory> loanHistories = loanHistoryRepository.findByBookTitle(bookTitle);

        List<LoanHistoryDTO> result = new ArrayList<>();
        for (LoanHistory loanHistory : loanHistories) {
            String userEmail = loanHistory.getAccount().getEmail();
            String bookTitleFromEntity = loanHistory.getBook().getTitle();
            Date loanDate = loanHistory.getLoanDate();
            Date returnDate = loanHistory.getReturnDate();

            LoanHistoryDTO loanHistoryDTO = LoanHistoryDTO.builder()
                    .userEmail(userEmail)
                    .bookTitle(bookTitleFromEntity)
                    .loanDate(loanDate)
                    .returnDate(returnDate)
                    .build();

            result.add(loanHistoryDTO);
        }
        return result;
    }

    // 도서에 대하여 반납처리한다 책제목을기반으로 찾아준다
    @Override
    public void returnBooksByBookTitle(String bookTitle) {
        List<LoanHistory> loanRecords = loanHistoryRepository.findByBookTitleAndReturnDateIsNull(bookTitle);
        Date date = new Date();
        for (LoanHistory loanRecord : loanRecords) {
            loanRecord.chReturnDate(date);
            loanHistoryRepository.save(loanRecord);

            // 대출 반납 후 도서의 대출 가능 여부를 true로 변경
            Book book = loanRecord.getBook();
            book.changeAvailableForLoan(true);
            bookRepository.save(book);
        }
    }
}
