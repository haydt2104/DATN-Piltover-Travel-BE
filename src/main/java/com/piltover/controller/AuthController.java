package com.piltover.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.request.SignUpReq;
import com.piltover.entity.Account;
import com.piltover.model.JwtRequestModel;
import com.piltover.model.JwtResponseModel;
import com.piltover.service.AccountService;
import com.piltover.service.AuthService;
import com.piltover.util.IDGenerator;
import com.piltover.util.JwtTokenUtil;
import com.piltover.util.ResponeUtil;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthService authService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	IDGenerator idGenerator;
	
	@Autowired
	ResponeUtil responeUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequestModel user) throws Exception {
		List<String> roleResps = new ArrayList<>();
		try {		
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername() , user.getPassword()));
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			// Check if the user is authenticated
			if (authentication != null && authentication.isAuthenticated()) {
				List<String> roleNames = authService.getRolesByUsername(user.getUsername());
				System.out.println("Role names:" +roleNames);
				List<GrantedAuthority> authList = new ArrayList<>();
				for (String roleName : roleNames) {
					authList.add(new SimpleGrantedAuthority("ROLE_" + roleName));
					roleResps.add("ROLE_" + roleName);
				}
				
				System.out.println("Auth list: "+authList);

				if (!roleNames.contains("USER")) {
					return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
				}
			}
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid credentials: " + user.getUsername() + " - " + user.getPassword());
			responeUtil.putRespone("message", "Username or password is incorrect");
			return ResponseEntity.badRequest().body(responeUtil.getRespone());
		}
		final String jwtToken = jwtTokenUtil.generateToken(user.getUsername());
		return ResponseEntity.ok(new JwtResponseModel(jwtToken, user.getUsername(), roleResps));
	}
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody Account account) {
		
		if (accountService.isEmailExists(account.getEmail())) {
			
			// Trả về lỗi 400 - BadRequest
			responeUtil.putRespone("message", "Địa chỉ email đã tồn tại trong hệ thống");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(responeUtil.getRespone());
		}

		if (accountService.isPhoneExists(account.getPhone())) {
			// Trả về lỗi 400 - BadRequest
			responeUtil.putRespone("message", "Số điện thoại đã tồn tại trong hệ thống");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(responeUtil.getRespone());
		}
		account.setId(idGenerator.generateRandomNumbers());
		Account newAccount = accountService.createAccount(account);

		responeUtil.putRespone("message", "Tạo tài khoản thành công");
		responeUtil.putRespone("newAccount", newAccount);

		System.out.println(responeUtil.getRespone());
		return ResponseEntity.ok(responeUtil.getRespone());
	}
	
}
