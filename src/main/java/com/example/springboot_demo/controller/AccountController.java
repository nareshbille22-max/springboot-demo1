package com.example.springboot_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final Set<String> accounts = new HashSet<>();

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest accountRequest) {
        String username = accountRequest.getUsername();
        String password = accountRequest.getPassword();
        if (username == null || password == null) {
            return new ResponseEntity<>("Username and password are required", HttpStatus.BAD_REQUEST);
        }
        if (accounts.contains(username)) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        accounts.add(username);
        return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AccountsResponse> getAllAccounts() {
        return ResponseEntity.ok(new AccountsResponse(new ArrayList<>(accounts)));
    }

}
