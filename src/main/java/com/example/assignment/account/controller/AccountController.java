package com.example.assignment.account.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.account.dto.AccountDTO;
import com.example.assignment.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account/")
public class AccountController {
    
    private final AccountService accountService;

     @PostMapping("register")
    public void registerAccount(@RequestBody AccountDTO accountDto) {
        accountService.registerAccount(accountDto);
    }
}
