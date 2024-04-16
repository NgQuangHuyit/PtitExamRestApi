package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.model.Account;
import com.ptit.ptitexam.service.AccountServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController()
public class AccountController {

    @Autowired
    private AccountServiceIml accountService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllAccounts() {
        System.out.println(accountService.findAll());
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable String id) {
        Optional<Account> account = accountService.findById(id);
        if (account.isPresent()) {
            return ResponseEntity.ok(account.get());
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }



}
