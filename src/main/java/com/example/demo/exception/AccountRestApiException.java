package com.example.demo.exception;

import com.example.demo.constant.AccountErrorCode;
import com.example.demo.controller.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.HttpClientErrorException;

@Getter
@Setter
public class AccountRestApiException extends RuntimeException {
    private int code;
    private String message;
    public AccountRestApiException(AccountErrorCode accountErrorCode) {
        this.code = accountErrorCode.getCode();
        this.message = accountErrorCode.getMessage();
    }
}
