package com.netoptc.tattoapp.modules.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netoptc.tattoapp.modules.account.entities.AccountEntity;
import com.netoptc.tattoapp.modules.account.services.CreateAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private CreateAccountService createAccountService;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody AccountEntity account) {
        return createAccountService.execute(account);
    }
} 
