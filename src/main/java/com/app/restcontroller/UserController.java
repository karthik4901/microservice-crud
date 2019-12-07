package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getUser/{Id}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		return null;		
	}
	
	@PostMapping(path="/saveuser")
	public ResponseEntity<String> createUser(@RequestBody User user){
		
		try {
			userRepository.save(user);
		}catch(Exception e) {
			return new ResponseEntity<String>("failed to create",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user created success fully",HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List> getAllUser(){
		return null;
		
	}

}
