package com.example.springboot_demo.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Setter
@Getter
public class AccountsResponse {
    private List<String> accounts;

    public AccountsResponse(List<String> accounts) {
        this.accounts = accounts;
    }

}
