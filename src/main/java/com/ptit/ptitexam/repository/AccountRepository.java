package com.ptit.ptitexam.repository;

import com.ptit.ptitexam.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
