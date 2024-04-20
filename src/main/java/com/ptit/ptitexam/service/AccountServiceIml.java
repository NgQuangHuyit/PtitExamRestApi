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
	//register
    @Autowired
    private AccountRepository accountRepository;
    public boolean registerUser(String username, String password, String email) {
    	if(accountRepository.existsByUsername(username)) {
    		return false;
    	}
    	Account user = new Account();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setEmail(email);
    	accountRepository.save(user);
    	return true;
    }
    
    public AccountDto loginAccount(String username, String password) {
    	Account accountEntity = accountRepository.findByUsernameAndPassword(username, password);
    	if(accountEntity != null) {
    		AccountDto accountDTO = new AccountDto();
    		accountDTO.setUsername(accountEntity.getUsername());
    		accountDTO.setPassword(accountEntity.getPassword());
    		return accountDTO;
    	} else {
    		return null;
    	}
    }
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
    }
    
    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        Account account = accountRepository.findAccountById(id);
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        account.setEmail(accountDto.getEmail());
        accountRepository.save(account);
        return accountDto;
    }
    
    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<AccountDto> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((acc) -> this.modelMapper.map(acc, AccountDto.class)).collect(Collectors.toList());
    }

//    @Override
//    public AccountDto createAccount(AccountDto accountDto) {
//        Account account = this.modelMapper.map(accountDto, Account.class);
//        Account savedAccount = accountRepository.save(account);
//        return this.modelMapper.map(savedAccount, AccountDto.class);
//    }

}
