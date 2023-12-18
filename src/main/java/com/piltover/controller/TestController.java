package com.piltover.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@GetMapping("/account")
	public ResponseEntity<?> getAllAccountActive() {
		System.out.println("Email 1: "+accountService.getAllAccount().get(0).getEmail());
		return ResponseEntity.ok(accountService.getAllAccount());
		
	}
	
	@PostMapping("/encode")
	public ResponseEntity<List<String>> encode(@RequestBody List<String> passwordList) {
		List<String> passwordEncode = new ArrayList<>();
		for (String pass : passwordList) {
			System.out.println(pass);
			for (String password : passwordList) {
				String passe = pe.encode(password);
				passwordEncode.add(passe);
				System.out.println(passe);
			}
		}
		
		return ResponseEntity.ok(passwordEncode);
		
	}
	
	@GetMapping("/username")
	public ResponseEntity<?> username() {
		// Lấy thông tin về người đăng nhập hiện tại
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Lấy tên người đăng nhập
        String username = authentication.getName();
		
		return ResponseEntity.ok(username);
		
	}
}
