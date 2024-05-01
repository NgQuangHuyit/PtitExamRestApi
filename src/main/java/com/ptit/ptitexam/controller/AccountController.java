package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.entity.Account;
import com.ptit.ptitexam.payload.AccountDto;
import com.ptit.ptitexam.service.AccountServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
public class AccountController {

    @Autowired
    private AccountServiceIml accountService;

    @PostMapping("/login")
    public String login( @RequestBody AccountDto account) {
    	AccountDto loggedInAccount = accountService.loginAccount(account.getUsername(), account.getPassword());
    	if(loggedInAccount != null) {
    		return "Login successful";
    	} else {
    		return "Invalid username or password";
    	}
    }
    
    @PostMapping("/register")
    public String register(@RequestBody AccountDto account) {
    	boolean isRegistered = accountService.registerUser(account.getUsername(), account.getPassword(), account.getEmail());
    	if(isRegistered) {
    		return "Registration successful";
    	} else {
    		return "Username already exists";
    	}
    }
    
    @PutMapping("/update/{id}")
    public String updateAccount(@PathVariable Long id, @RequestBody AccountDto account) {
        accountService.updateAccount(id, account);
        return "Account updated successfully";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "Account deleted successfully";
    }
    
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

//    @PostMapping("/user")
//    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
//        AccountDto account = accountService.createAccount(accountDto);
//        return new ResponseEntity<>(account, HttpStatus.CREATED);
//    }


}
