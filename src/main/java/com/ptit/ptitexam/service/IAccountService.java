package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.Account;
import com.ptit.ptitexam.payload.AccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface IAccountService {

    List<AccountDto> findAll();

    boolean registerUser(String username, String password, String email);
    
    AccountDto loginAccount(String username, String password);   
    
    void deleteAccount(Long id);

	AccountDto updateAccount(Long id, AccountDto accountDto);

	Optional<Account> findAccountById(Long id);
}
