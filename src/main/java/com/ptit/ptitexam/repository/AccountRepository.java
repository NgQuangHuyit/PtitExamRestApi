package com.ptit.ptitexam.repository;

import com.ptit.ptitexam.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository<Acount> extends JpaRepository<Account, Long> {
	boolean existsByUsername(String username);
	Account findByUsernameAndPassword(String username, String password);
}
