package com.app.restcontroller;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		
		Optional<User> userById = userRepository.findById(id);
		User user = userById.get();
		return new ResponseEntity<User>(user,HttpStatus.OK);		
	}
	
	@PostMapping(path="/saveuser")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		
		User usderFromDb = null;
		try {
			 usderFromDb = userRepository.save(user);
		}catch(Exception e) {
			return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("user created success fully with "+usderFromDb.getUserId(),HttpStatus.OK);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List> getAllUser(){
		return null;
		
	}

}
