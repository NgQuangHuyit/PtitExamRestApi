package com.ptit.ptitexam.service;

import com.ptit.ptitexam.model.Account;
import com.ptit.ptitexam.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceIml implements IAccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }
}
