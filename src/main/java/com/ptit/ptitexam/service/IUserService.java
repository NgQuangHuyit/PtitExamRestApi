package com.ptit.ptitexam.service;

import com.ptit.ptitexam.payload.request.LoginDto;
import com.ptit.ptitexam.payload.request.RegisterDto;
import com.ptit.ptitexam.payload.UserDetailDto;

import java.util.List;

public interface IUserService {

    List<UserDetailDto> findAll();

    UserDetailDto registerUser(RegisterDto registerDto);

    boolean loginAccount(LoginDto loginDto);

    void deleteUserById(Long id);

    UserDetailDto updateUser(Long id, UserDetailDto userDetailDto);

    UserDetailDto findAccountById(Long id);

    List<UserDetailDto> searchByFullName(String fullName);
}
