package com.movie.movie.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.movie.users.models.User;

@Service
public class UserServices {
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepo;
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.insert(user); 
	}
	public List<User> getUsers(){
		return userRepo.findAll();
	}
}
