package com.Beelab.Service;


import java.util.List;

import com.Beelab.Entity.User;


public interface UserService {

	public List<User> getAllUser();
	
   public User create(User user);

   public User changePassword(int userId);

   public User findOneById(int id);

   public User findOneByPhone(String phoneNumber);

   public User findOneByUsername(String fullName);

   public User findOneByGmail(String email);

   public User update(User user);
}
