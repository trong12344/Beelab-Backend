package com.Beelab.API;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Beelab.Entity.User;
import com.Beelab.Service.UserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class UserAPI {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUser();
		
	}
		
	@PostMapping(("/create"))
	public User createUser(@RequestBody User user) {		
		 LocalDateTime now = LocalDateTime.now();
	     user.setCreated_at(now);
	     user.setUpdated_at(now);
		return userService.create(user);
		
	}
	
	@PutMapping(("/update/{id}"))
	public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {	
		
		 LocalDateTime now = LocalDateTime.now();
		
	     user.setUpdated_at(now);    
		return userService.update(user);
		
	}
	

}
