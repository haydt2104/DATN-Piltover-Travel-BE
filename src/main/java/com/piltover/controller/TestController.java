package com.piltover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/account")
	public ResponseEntity<?> getAllAccountActive() {
		System.out.println("Email 1: "+accountService.getAllAccount().get(0).getEmail());
		return ResponseEntity.ok(accountService.getAllAccount());
		
	}
}
