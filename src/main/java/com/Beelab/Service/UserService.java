package com.Beelab.Service;


import java.util.List;

import com.Beelab.Entity.User;


public interface UserService {

   public User create(User user);

   public User changePassword(User userChangePasswordDTO, int userId);

   public void transportEmail(String email, String verifyCode);

//    User verifyCode(UserVerifyCodeDTO userVerifyCodeDTO);

   public User findOneById(int id);

   public User findOneByPhone(String phoneNumber);

   public User findOneByUsername(String fullName);

   public User findOneByGmail(String email);

   public void update(User user);
}
