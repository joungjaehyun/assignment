package com.example.assignment.account.service;


import com.example.assignment.account.dto.AccountDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface AccountService {
    

    void registerAccount(AccountDTO accountDTO);
}
