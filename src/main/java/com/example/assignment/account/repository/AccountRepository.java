package com.example.assignment.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);

}
