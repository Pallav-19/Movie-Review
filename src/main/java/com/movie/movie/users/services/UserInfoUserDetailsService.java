package com.movie.movie.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.movie.movie.users.models.User;
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user =userRepo.findByName(username);
		return user.map(USerInfoUSerDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not found"));
		
	}

}
