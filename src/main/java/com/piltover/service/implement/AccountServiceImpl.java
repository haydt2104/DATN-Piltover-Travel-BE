package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Account;
import com.piltover.repository.AccountRepository;
import com.piltover.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccountActive() {
		return accountRepository.findAllActiveAccounts();
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
}
