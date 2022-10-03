package com.example.demo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {
    private String username;
    private String password;
    private String email;
}
