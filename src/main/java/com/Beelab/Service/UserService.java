//package com.Beelab.Service;
//
//
//import java.util.List;
//import java.util.Optional;
//
//import com.Beelab.Common.PageResponse;
//import com.Beelab.Entity.User;
//import org.springframework.http.ResponseEntity;
//
//
//public interface UserService {
//
//   public ResponseEntity<List<UserDTO>> getListUser();
//   public User create(User user);
//   public User update(User user);
//   public User findOneById(int id);
//   PageResponse<User> search(String fullName, String email, String phoneNumber, int page, int size);
//   public User changePassword(int id, ChangePasswordDTO changePasswordDTO);
//   public User forgetPassword(ForgetPasswordDTO forgetPasswordDTO);
//   public User resetPassword(ResetPasswordDTO resetPasswordDTO);
//   public User findOneByPhone(String phoneNumber);
//   public User findOneByUsername(String fullName);
//   public User findOneByEmail(String email);
////   public User delete(int id);
//}
