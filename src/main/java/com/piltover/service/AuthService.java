package com.piltover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.piltover.entity.Account;
import com.piltover.entity.Authority;
import com.piltover.repository.AccountRepository;
import com.piltover.repository.AuthorityRepository;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Lazy
	@Autowired
	BCryptPasswordEncoder pe;

	public Optional<Account> getAccount(String username){
		return accountRepository.findByEmail(username);
	}

	public List<String> getRolesByUsername(String username){

		List<String> roleNames = new ArrayList<>();

		List<Authority> authorities = authorityRepository.findAll();

		for (Authority authority : authorities) {
			if(authority.getAccount().getEmail().equals(username)){
				roleNames.add(authority.getRole().getId());
			}
		}
		return roleNames;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
            System.out.println("UserService......................");
            Account user = accountRepository.findByEmail(username).orElse(null);
            System.out.println(user.getEmail() + " - " + user.getPassword() + " - " +pe.encode(user.getPassword()));
            String password = user.getPassword();
            List<String> listR = getRolesByUsername(username);
            for (String role : listR) {
                System.out.println("Role: " + role);
            }
            // String[] roles = { "ADMIN" };
            // String[] roles = account.getAuthorities().stream()
            // .map(au -> au.getRole().getId())
            // .collect(Collectors.toList()).toArray(new String[0]);
            // System.out.println("pass: " + password);
            // System.out.println("role: " + Arrays.toString(roles));
            return User.withUsername(username)
                    .password(pe.encode(password))
                    .roles(listR.toArray(new String[0])).build();
        } catch (Exception e) {
            throw new UsernameNotFoundException(username + "not found");
        }
	}

}
