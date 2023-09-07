package com.example.assignment.account.service;

import org.springframework.stereotype.Service;

import com.example.assignment.account.dto.AccountDTO;
import com.example.assignment.account.entity.Account;
import com.example.assignment.account.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService{

    private final AccountRepository repository;

    
    @Override
    public void registerAccount(AccountDTO accountDTO) {

        // pw의경우 security 적용시 password encoder 필요

        Account account = Account.builder()
        .email(accountDTO.getEmail())
        .pw(accountDTO.getPw())
        .intro(accountDTO.getIntro())
        .address(accountDTO.getAddress())
        .build();

        repository.save(account);
        
    }
    
}
