package com.example.demo.middleware;

import com.example.demo.constant.AccountErrorCode;
import com.example.demo.controller.request.AddAccountRequest;
import com.example.demo.controller.request.LoginAccountRequest;
import com.example.demo.controller.request.UpdateAccountRequest;
import com.example.demo.exception.AccountRestApiException;
import com.example.demo.util.ValidateField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountVerifyRequestServiceImpl implements AccountVerifyRequestServive {
    @Autowired
    private ValidateField validateField;
    @Override
    public void verifyaddAccount(AddAccountRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        if (username == null || username.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_PASSWORD_FIELD);
        }
        if (email == null || email.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_EMAIL_FIELD);
        }
        if (!validateField.validEmail(email)) {
            throw new AccountRestApiException(AccountErrorCode.EMAIL_INVALID);
        }
        if (!validateField.validUsername(username)) {
            throw new AccountRestApiException(AccountErrorCode.USERNAME_INVALID);
        }
        if (!validateField.validPassword(password)) {
            throw new AccountRestApiException(AccountErrorCode.PASSWORD_INVALID);
        }
    }

    @Override
    public void verifyLoginAccount(LoginAccountRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if (username == null || username.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_PASSWORD_FIELD);
        }
        if (!validateField.validUsername(username)) {
            throw new AccountRestApiException(AccountErrorCode.USERNAME_INVALID);
        }
        if (!validateField.validPassword(password)) {
            throw new AccountRestApiException(AccountErrorCode.PASSWORD_INVALID);
        }
    }

    @Override
    public void verifyUpdateAccount(UpdateAccountRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        if (username == null || username.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_PASSWORD_FIELD);
        }
        if (email == null || email.trim().isEmpty()) {
            throw new AccountRestApiException(AccountErrorCode.MISSING_EMAIL_FIELD);
        }
        if (!validateField.validEmail(email)) {
            throw new AccountRestApiException(AccountErrorCode.EMAIL_INVALID);
        }
        if (!validateField.validUsername(username)) {
            throw new AccountRestApiException(AccountErrorCode.USERNAME_INVALID);
        }
        if (!validateField.validPassword(password)) {
            throw new AccountRestApiException(AccountErrorCode.PASSWORD_INVALID);
        }
    }
}
