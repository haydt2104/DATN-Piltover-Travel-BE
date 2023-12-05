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

import com.piltover.model.JwtRequestModel;
import com.piltover.model.JwtResponseModel;
import com.piltover.service.AuthService;
import com.piltover.util.JwtTokenUtil;

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

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody JwtRequestModel user) throws Exception {
		
		try {		
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername() , user.getPassword()));
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			List<GrantedAuthority> authList = new ArrayList<>();
			// Check if the user is authenticated
			if (authentication != null && authentication.isAuthenticated()) {
				List<String> roleNames = authService.getRolesByUsername(user.getUsername());
				System.out.println("Role names:" +roleNames);

				for (String roleName : roleNames) {
					authList.add(new SimpleGrantedAuthority("ROLE_" + roleName));
				}

				if (!roleNames.contains("USER")) {
					return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
				}
			}
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid credentials: " + user.getUsername() + " - " + user.getPassword());
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final String jwtToken = jwtTokenUtil.generateToken(user.getUsername());
		return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	}
}
