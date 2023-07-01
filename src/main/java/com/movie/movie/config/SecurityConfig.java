package com.movie.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.movie.movie.users.services.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
@Bean	
public UserDetailsService userDetailsService() {
	return new UserInfoUserDetailsService();
}
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	return  http
	        .csrf().disable()
	        .authorizeRequests()
	            .requestMatchers("/api/movie/welcome", "/user/**","/users").permitAll()
	            .requestMatchers("/api/**").authenticated()
	        .and()
	        .formLogin()
	        .and()
	        .build();
}
@Bean
public PasswordEncoder passwordEncoder() {
 return new BCryptPasswordEncoder();
}
@Bean
public AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(userDetailsService());
	authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider; 
}
}

