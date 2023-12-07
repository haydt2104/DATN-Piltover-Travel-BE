package com.piltover.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.piltover.filter.JwtAuthenticationTokenFilter;
import com.piltover.service.AuthService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Configuration
	@Order(1)
	public static class RestApiSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private JwtAuthenticationTokenFilter jwtauthFilter;

		@Autowired
		AuthService authService;

		// /*--Mã hóa mật khẩu--*/
		@Lazy
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
//		@Bean
//	    @Override
//	    protected UserDetailsService userDetailsService() {
//			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        UserDetails user1 = User.builder()
//	                .username("user1")
//	                .password(passwordEncoder.encode("password1"))
//	                .roles("USER")
//	                .build();
//
//	        UserDetails user2 = User.builder()
//	                .username("user2")
//	                .password(passwordEncoder.encode("password2"))
//	                .roles("USER")
//	                .build();
//
//	        return new InMemoryUserDetailsManager(user1, user2);
//	    }

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(authService);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors();
			http.csrf().disable().antMatcher("/api/**").authorizeRequests()
			.antMatchers("/api/auth/**", "/api/home/**", "/api/post/**", "/api/tour_plan/**", "/api/tour_image/**", "/api/booking/**", "/api/tour_date/**", "/api/tour/**").permitAll()
			.antMatchers("/api/admin/**").hasAnyRole("ADMIN")
					.antMatchers("/api/**").hasAnyRole("USER")
					
					.anyRequest().permitAll().and()
					.addFilterBefore(jwtauthFilter, UsernamePasswordAuthenticationFilter.class);

			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
	}
}
