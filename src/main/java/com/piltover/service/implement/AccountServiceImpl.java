package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Account;
import com.piltover.repository.AccountRepository;
import com.piltover.repository.AuthorityRepository;
import com.piltover.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired 
	AuthorityRepository authorityRepository;

	@Override
	public List<Account> getAllAccountActive() {
		return accountRepository.findAllActiveAccounts();
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {	
		accountRepository.saveAndFlush(account);
		return account;
		
	}

	@Override
	public boolean isEmailExists(String email) {
		List<String> listE = accountRepository.getAllEmails();
		for (String emailC : listE) {
			if(emailC.equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isPhoneExists(String phone) {
		List<String> listP = accountRepository.getAllEmails();
		for (String phoneC : listP) {
			if(phoneC.equalsIgnoreCase(phone)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isIDExists(Long id) {
		if(accountRepository.existsById(id)) {
			return true;
		}
		return false;
	}

	@Override
	public Account findUserByID(Long id) {
		return accountRepository.findById(id).get();
	}

}
