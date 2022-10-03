package com.example.demo.middleware;

import com.example.demo.controller.request.AddAccountRequest;
import com.example.demo.controller.request.LoginAccountRequest;
import com.example.demo.controller.request.UpdateAccountRequest;

public interface AccountVerifyRequestServive {
    void verifyaddAccount(AddAccountRequest request);
    void verifyLoginAccount(LoginAccountRequest request);
    void verifyUpdateAccount(UpdateAccountRequest request);
}
