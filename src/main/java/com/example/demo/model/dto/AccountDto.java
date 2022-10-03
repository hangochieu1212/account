package com.example.demo.model.dto;

import com.example.demo.model.entity.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountDto extends BaseModel {
    @JsonProperty(namespace = "username")
    private String username;
    @JsonProperty(namespace = "password")
    private String password;
    @JsonProperty(namespace = "email")
    private String email;
}
