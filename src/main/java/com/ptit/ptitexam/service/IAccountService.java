package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.Account;
import com.ptit.ptitexam.payload.AccountDto;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<AccountDto> findAll();

    AccountDto createAccount(AccountDto accountDto);


}
