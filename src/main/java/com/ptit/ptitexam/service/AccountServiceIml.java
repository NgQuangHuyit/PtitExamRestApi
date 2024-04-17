package com.ptit.ptitexam.service;

import com.ptit.ptitexam.entity.Account;
import com.ptit.ptitexam.payload.AccountDto;
import com.ptit.ptitexam.repository.AccountRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceIml implements IAccountService{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<AccountDto> findAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = accounts.stream().map((acc) -> this.modelMapper.map(acc, AccountDto.class)).collect(Collectors.toList());
        return accountDtos;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = this.modelMapper.map(accountDto, Account.class);
        Account savedAccount = accountRepository.save(account);
        return this.modelMapper.map(savedAccount, AccountDto.class);
    }


}
