package com.example.demo.controller;

import com.example.demo.business.AccountBusiness;
import com.example.demo.controller.request.AddAccountRequest;
import com.example.demo.controller.request.LoginAccountRequest;
import com.example.demo.controller.request.UpdateAccountRequest;
import com.example.demo.controller.response.BaseResponse;
import com.example.demo.model.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountBusiness accountBusiness;

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addAccount(@RequestBody AddAccountRequest request) {
        return null;
    }
    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable("id") int id) {
        return accountBusiness.getAccount(id);
    }
    @GetMapping("/list")
    public List<AccountDto> getAllAccount() {
        return accountBusiness.getAllAccount();
    }
    @PutMapping("/update/{id}")
    public AccountDto updateAccount(@PathVariable("id") int id, @RequestBody UpdateAccountRequest request) {
        return accountBusiness.updateAccount(id, request);
    }
    @PostMapping("/login")
    public AccountDto deleteAccount(@RequestBody LoginAccountRequest request) {
        return accountBusiness.loginAccount(request);
    }
}
