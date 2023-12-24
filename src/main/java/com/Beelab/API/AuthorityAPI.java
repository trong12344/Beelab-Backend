//package com.Beelab.API;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Beelab.Entity.Authority;
//import com.Beelab.Service.AuthorityService;
//
//
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/authorities")
//public class AuthorityAPI {
//
//	@Autowired
//	AuthorityService authorityService;
//
//	@GetMapping
//	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin) {
//		if (admin.orElse(false)) {
//			return authorityService.findAuthoritiesOfAdministrators();
//		}
//		return authorityService.findAll();
//	}
//
//	@PostMapping
//	public Authority post(@RequestBody Authority auth) {
//		return authorityService.create(auth);
//	}
//
//	@DeleteMapping("{id}")
//	public void delete(@PathVariable("id") Integer id) {
//		authorityService.delete(id);
//		
//		
//	}
//	
//	
//}
