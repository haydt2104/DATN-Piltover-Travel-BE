package com.piltover.service;

import java.util.List;

import com.piltover.entity.Account;

public interface AccountService {

	// Lấy tất cả account
	List<Account> getAllAccount();

	// Lấy tất cả account hoạt động
	List<Account> getAllAccountActive();
	
	// Tạo tài khoản mới
	Account createAccount(Account account);
	
	// Kiểm tra email
	boolean isEmailExists(String email);
	
	// Kiểm tra phone
	boolean isPhoneExists(String phone);
	
	// Kiểm tra id
	boolean isIDExists(Long id);
	
	// Lấy account vs id
	Account findUserByID(Long id);
	
	//Lấy id từ email
	long getId(String email);
	
	// Thêm role
	void addRole(String email, String role);
}
