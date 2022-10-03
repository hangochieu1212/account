package com.example.demo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginAccountRequest {
    private String username;
    private String password;
}
