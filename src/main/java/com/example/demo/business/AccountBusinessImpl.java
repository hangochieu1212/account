package com.example.demo.business;

import com.example.demo.constant.AccountErrorCode;
import com.example.demo.controller.request.AddAccountRequest;
import com.example.demo.controller.request.LoginAccountRequest;
import com.example.demo.controller.request.UpdateAccountRequest;
import com.example.demo.exception.AccountRestApiException;
import com.example.demo.middleware.AccountVerifyRequestServive;
import com.example.demo.model.dto.AccountDto;
import com.example.demo.model.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.util.IDGeneratorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountBusinessImpl implements AccountBusiness {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountVerifyRequestServive verifyRequestServive;
    @Override
    public AccountDto getAccount(int id) {
        Account account = accountService.findAccountById(id);
        return convertAccountToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountService.getAllAccount();
        List<AccountDto> accountDtos = new ArrayList<>();
        accounts.forEach(account -> {
            accountDtos.add(convertAccountToAccountDto(account));
        });
        return accountDtos;
    }

    @Override
    public AccountDto addAccount(AddAccountRequest request) {
        verifyRequestServive.verifyaddAccount(request);
        boolean existEmail = accountService.existUserByEmail(request.getEmail());
        boolean existUsername = accountService.existUserByUsername(request.getUsername());
        String code = IDGeneratorUtil.gen();
        if(existEmail == true) {
            throw new AccountRestApiException(AccountErrorCode.EMAIL_EXIST);
        }
        if(existUsername == true) {
            throw new AccountRestApiException(AccountErrorCode.USERNAME_EXIST);
        }
        Account account = new Account();
        account.setCode(code);
        account.setUsername(request.getUsername());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setEmail(request.getEmail());
        accountService.addAccount(account);
        return convertAccountToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(int id, UpdateAccountRequest request) {
        verifyRequestServive.verifyUpdateAccount(request);
        Account account = accountService.findAccountById(id);
        if(account != null) {
            account.setUsername(request.getUsername());
            account.setPassword(request.getPassword());
            account.setEmail(request.getEmail());
            accountService.addAccount(account);
            return convertAccountToAccountDto(account);
        }
        System.out.println("Id does not exist");
        return null;
    }

    @Override
    public AccountDto loginAccount(LoginAccountRequest request) {
        verifyRequestServive.verifyLoginAccount(request);
        Account account = accountService.getAccountByUsername(request.getUsername());
        if(account !=null) {
            if(account.getPassword().equals(request.getPassword())) {
                System.out.println("Success");
                account.setLastLogin(new Date());
                return convertAccountToAccountDto(account);
            }
            System.out.println("Invalid username or password.");
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public AccountDto convertAccountToAccountDto(Account account) {
        if(account == null) return null;
        try {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(account, AccountDto.class);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
