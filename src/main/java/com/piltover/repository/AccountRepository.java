package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query("SELECT a FROM Account a WHERE a.active = true")
    List<Account> findAllActiveAccounts();
}
