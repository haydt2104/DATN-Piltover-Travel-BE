package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getAllAccount() {
		return ResponseEntity.ok(accountService.getAllAccount());
	}
}
