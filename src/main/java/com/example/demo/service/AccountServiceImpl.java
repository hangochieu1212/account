package com.example.demo.service;

import com.example.demo.model.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public boolean deleteAccount(Account account) {
       try {
            accountRepository.delete(account);
           return true;
       } catch(Exception e) {
           System.out.println(e);
           return false;
       }
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public boolean existUserByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public boolean existUserByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
