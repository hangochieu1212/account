package com.example.demo.business;

import com.example.demo.controller.request.AddAccountRequest;
import com.example.demo.controller.request.LoginAccountRequest;
import com.example.demo.controller.request.UpdateAccountRequest;
import com.example.demo.model.dto.AccountDto;
import java.util.List;

public interface AccountBusiness {
    AccountDto getAccount(int id);
    List<AccountDto> getAllAccount();
    AccountDto addAccount(AddAccountRequest request);
    AccountDto updateAccount(int id, UpdateAccountRequest request);
    AccountDto loginAccount(LoginAccountRequest request);


}
