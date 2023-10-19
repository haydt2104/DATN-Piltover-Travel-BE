package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Account;
import com.piltover.service.AccountService;
import com.piltover.util.IDGenerator;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	ResponeUtil responeUtil;
	
	@Autowired
	IDGenerator idGenerator;
	
	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getAllAccount() {
		return ResponseEntity.ok(accountService.getAllAccount());
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody Account account){
		
		if (accountService.isEmailExists(account.getEmail())) {
	        // Trả về lỗi 400 - BadRequest
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .body("Địa chỉ email đã tồn tại trong hệ thống");
	    }
		
		if (accountService.isPhoneExists(account.getPhone())) {
	        // Trả về lỗi 400 - BadRequest
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .body("Số điện thoại đã tồn tại trong hệ thống");
	    }
		
		account.setId(idGenerator.generateRandomNumbers());
		Account newAccount = accountService.createAccount(account);
		
		
		responeUtil.putRespone("message", "Tạo tài khoản thành công");
		responeUtil.putRespone("newAccount", newAccount);
		
		System.out.println(responeUtil.getRespone());
		return ResponseEntity.ok(responeUtil.getRespone());
	}
	
	@PostMapping("/test")
	public ResponseEntity<?> testRespone(){
		return ResponseEntity.ok(responeUtil.getRespone());
	}
}