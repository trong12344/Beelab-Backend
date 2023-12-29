package com.Beelab.Imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.UserDAO;
import com.Beelab.Entity.User;
import com.Beelab.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	

	public User create(User user) {
		return userDAO.save(user);
	}


	public User changePassword(User userChangePasswordDTO, int userId) {
		 Optional<User> optionalUser = userDAO.findById(userId);
	        if (optionalUser.isPresent()) {
	            User existingUser = optionalUser.get();	   
	            String newPassword = userChangePasswordDTO.getPassword();
	            existingUser.setPassword(newPassword);
	            userDAO.save(existingUser);
	            return existingUser;
	        } else {
	            throw new NoSuchElementException("User not found with ID: " + userId);
	        }
	}

	@Override
	public User findOneById(int id) {
		return userDAO.findById(id).get();
	}

	@Override
	public User findOneByPhone(String phoneNumber) {
			return userDAO.findByPhone(phoneNumber);
	}

	@Override
	public User findOneByUsername(String fullName) {
		// TODO Auto-generated method stub
		return (User) userDAO.findByUserName(fullName);
	}

	@Override
	public User findOneByGmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.findByGmail(email);
	}

	@Override
	public User update(User user) {
		return userDAO.save(user);
		
	}

	@Override
	public User changePassword(int userId) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
