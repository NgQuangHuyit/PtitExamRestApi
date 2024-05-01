package com.ptit.ptitexam.controller;

import com.ptit.ptitexam.payload.Session;
import com.ptit.ptitexam.payload.request.RegisterDto;
import com.ptit.ptitexam.payload.UserDetailDto;
import com.ptit.ptitexam.payload.response.ApiResponse;
import com.ptit.ptitexam.payload.request.LoginDto;
import com.ptit.ptitexam.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("users/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Session session = userService.loginAccount(loginDto);
        if(session == null) {
            return new ResponseEntity<>(new ApiResponse<>("Wrong username or password", false, null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse<>("Login successful", true, session), HttpStatus.OK);
        }
    }

    @PostMapping("users/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        UserDetailDto acc = userService.registerUser(registerDto);
        return ResponseEntity.ok(new ApiResponse<>("User registered successfully", true, acc));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findAccountById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @RequestBody UserDetailDto userDetailDto) {
        UserDetailDto user = userService.updateUser(id, userDetailDto);
        return new ResponseEntity<>(new ApiResponse<>("User was updated successfully", true, user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(new ApiResponse<>("User was deleted successfully", true), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllAccounts() {
        List<UserDetailDto> accountDtos = userService.findAll();
        accountDtos.forEach(System.out::println);
        return ResponseEntity.ok(accountDtos);
    }

    @GetMapping("/users/search")
    public ResponseEntity<?> searchUser(@RequestParam String searchValue) {
        return ResponseEntity.ok(userService.searchByFullName(searchValue.replaceAll("\s\s+", " ").trim()));
    }

}
