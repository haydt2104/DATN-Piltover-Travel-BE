package com.piltover.service;

import java.util.List;


import com.piltover.entity.Account;


public interface AccountService {
	
	// Lấy tất cả account
	List<Account> getAllAccount();
	
	// Lấy tất cả account hoạt động
	List<Account> getAllAccountActive();
}
