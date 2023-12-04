package com.piltover.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
		@Bean
		public BCryptPasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
		
		@Bean
	    @Override
	    protected UserDetailsService userDetailsService() {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        UserDetails user1 = User.builder()
	                .username("user1")
	                .password(passwordEncoder.encode("password1"))
	                .roles("USER")
	                .build();

	        UserDetails user2 = User.builder()
	                .username("user2")
	                .password(passwordEncoder.encode("password2"))
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(user1, user2);
	    }

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(authService);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors();
			http.csrf().disable().antMatcher("/api/**").authorizeRequests()
			.antMatchers("/api/auth/**", "/api/home/**", "/api/post/**").permitAll()
					.antMatchers("/api/**").hasAnyRole("USER")
					
					.anyRequest().permitAll().and()
					.addFilterBefore(jwtauthFilter, UsernamePasswordAuthenticationFilter.class);

			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
	}

//    @Configuration
//    @Order(2)
//    public static class LoginFormSecurityConfig extends WebSecurityConfigurerAdapter {
//        @Autowired
//        AuthService authService;
//
//        // /*--Mã hóa mật khẩu--*/
//        @Bean
//        public BCryptPasswordEncoder getPasswordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(authService);
//        }
//
//        @Bean
//        @Override
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//
//        // Phân quyền sử dụng
//        /*--Phân quyền sử dụng và hình thức đăng nhập--*/
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            // CSRF, CORS
//            http.csrf().disable().cors().disable();
//
//            // Phân quyền sử dụng
//            http.authorizeRequests()
//                    .antMatchers("/admin/login").permitAll()
//                    .antMatchers("/admin/index").hasRole("ADMIN")
//                    .anyRequest().permitAll(); // anonymous
//
//            // Điều khiển lỗi truy cập không đúng vai trò
//            http.exceptionHandling()
//                    .accessDeniedPage("/admin/access/denied"); // [/error]
//
//            // Giao diện đăng nhập
//            http.formLogin()
//                    .loginPage("/admin/login/form")
//                    .loginProcessingUrl("/admin/login") // [/login]
//                    .defaultSuccessUrl("/admin/index", false)
//                    .failureUrl("/admin/login/error")
//                    .usernameParameter("username") // [username]
//                    .passwordParameter("password"); // [password]
//            http.rememberMe()
//                    .rememberMeParameter("remember"); // [remember-me]
//
//            // Đăng xuất
//            http.logout()
//                    .logoutUrl("/admin/logoff") // [/logout]
//                    .logoutSuccessUrl("/admin/logoff/success");
//        }
//    }
}
