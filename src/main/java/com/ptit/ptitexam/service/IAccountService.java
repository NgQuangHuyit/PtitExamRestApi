package com.ptit.ptitexam.service;

import com.ptit.ptitexam.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<Account> findAll();

    Optional<Account> findById(String id);
}
