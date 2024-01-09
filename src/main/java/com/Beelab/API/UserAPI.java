package com.Beelab.API;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import com.Beelab.Common.PageResponse;
import com.Beelab.dto.userdto.ChangePasswordDTO;
import com.Beelab.dto.userdto.ForgetPasswordDTO;
import com.Beelab.dto.userdto.ResetPasswordDTO;
import com.Beelab.dto.userdto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Beelab.Entity.User;
import com.Beelab.Service.UserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class UserAPI {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> getListUser() {
		return userService.getListUser();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id){
		return ResponseEntity.ok(userService.findOneById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<PageResponse<User>> getListUser(
			@RequestParam(value = "full_name" , required = false)  String fullName,
			@RequestParam(value = "email" , required = false) String email,
			@RequestParam(value = "phoneNumber" ,required = false) String phoneNumber,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
	){
		return ResponseEntity.ok(userService.search(fullName,email,phoneNumber,page,size));
	}

	@GetMapping("/{id}/detail")
	public ResponseEntity<User> findOneById(@PathVariable("id") int id){
		return ResponseEntity.ok(userService.findOneById(id));
	}

	@PutMapping("/{id}/update")
	public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setUpdated_at(LocalDateTime.now());
		return ResponseEntity.ok(userService.update(user));
	}
	// Đổi mật khẩu:
	// - Lấy mật khẩu của User từ db lên ( đã mã hóa = B64 & BCrypt )
	// - Nhận trường mật khẩu hiện tại, encode sang B64 ( FE ), encode sang BCrypt
	// - So sánh chuỗi sau encode BCrypt của trường mật khẩu hiện tại và chuỗi của mật khẩu User
	// 	if bằng nhau thì cho phép thay đổi mật khẩu, nhận mật khẩu mới, encode sang B64 ( FE ), encode sang BCrypt và thực hiện update xuống DB
	// 	else trả noti sai mật khẩu

	@PutMapping("/{id}/change-password")
	public ResponseEntity<User> changePassword(@PathVariable("id") int id, @RequestBody ChangePasswordDTO changePasswordDTO)
	{
//		byte[] decodedBytes = Base64.getDecoder().decode(currentPassword);
		return ResponseEntity.ok(userService.changePassword(id, changePasswordDTO));
	}

	@PutMapping("/forget-password")
	public ResponseEntity<User> forgetPassword(@RequestBody ForgetPasswordDTO forgetPasswordDTO){
		return ResponseEntity.ok(userService.forgetPassword(forgetPasswordDTO));
	}

	@PutMapping("/reset-password")
	public ResponseEntity<User> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
		return ResponseEntity.ok(userService.resetPassword(resetPasswordDTO));
	}

//
//	@GetMapping("/phone")
//	public User getUserByPhone(@RequestParam(value="value",defaultValue = "0") String phoneNumber){
//		return userService.findOneByPhone(phoneNumber);
//	}
//
//	@GetMapping("/full_name")
//	public User findOneByUsername(@RequestParam(value="value",defaultValue = "0") String fullName){
//		return userService.findOneByUsername(fullName);
//	}
//	@GetMapping("/email")
//	public User findOneByEmail(@RequestParam(value="value",defaultValue = "0") String email){
//		return userService.findOneByEmail(email);
//	}

//	@PostMapping("/register")
//	public User create(@RequestBody User user) {
//		 LocalDateTime now = LocalDateTime.now();
//	     user.setCreated_at(now);
//	     user.setUpdated_at(now);
//		return userService.create(user);
//	}

}