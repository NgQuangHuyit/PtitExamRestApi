package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.payload.AccountDto;
import com.ptit.ptitexam.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllAccounts() {
        List<AccountDto> accountDtos = accountService.findAll();
        accountDtos.forEach(System.out::println);
        return ResponseEntity.ok(accountDtos);
    }

//    @GetMapping("/userinfo/{id}")
//    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
//        Optional<Account> account = accountService.findById(id);
//        if (account.isPresent()) {
//            return ResponseEntity.ok(account.get().getAccountInfo());
//        }
//        else
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

//    }

    @PostMapping("/user")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }


}
