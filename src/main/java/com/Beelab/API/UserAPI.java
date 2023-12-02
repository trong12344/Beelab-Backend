package com.Beelab.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Beelab.Entity.User;
import com.Beelab.Service.UserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class UserAPI {

//	@Autowired
//	UserService accountService;
//
////	@GetMapping
////	public List<User> getAccounts(@RequestParam("admin") Optional<Boolean> admin) {
////		if (admin.orElse(false)) {
////			return accountService.getAdministrators();
////		}
////		return accountService.findAll();
////	}
////	
}
