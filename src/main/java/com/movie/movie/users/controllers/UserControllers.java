package com.movie.movie.users.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.users.models.User;
import com.movie.movie.users.services.UserServices;

@RequestMapping
@RestController
@CrossOrigin
public class UserControllers {
 @Autowired
 public UserServices userService;
 
 @PostMapping("/user/add")
 public ResponseEntity<User> addUser(@RequestBody User user){
	 return new ResponseEntity<User>(userService.addUser(user),HttpStatus.OK);
 }
 @GetMapping("/users")
 public ResponseEntity<List<User>> getUSers(){
	 return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
	 
 }
}
