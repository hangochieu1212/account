package com.example.demo.service;

import com.example.demo.model.entity.Account;

import java.util.List;

public interface AccountService {
    Account findAccountById(int id);
    boolean deleteAccount(Account account);
    List<Account> getAllAccount();
    boolean existUserByUsername(String username);
    boolean existUserByEmail (String email);

    Account addAccount(Account account);
    Account getAccountByUsername(String username);
}
