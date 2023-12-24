package com.Beelab.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.AdminDAO;
import com.Beelab.DAO.CartDAO;
import com.Beelab.Entity.Admin;
import com.Beelab.Entity.Cart;
import com.Beelab.Service.AdminService;

import java.util.Date;

@Service 
public class AdminServiceImpl implements AdminService{
@Autowired
AdminDAO cdao;
	@Override
	public Admin createAdmin(Admin admin) {
		return cdao.save(admin);
	}
	@Override
	public Admin changePassword() {
	
		return null;
	}

	public Admin findOneById(int id) {
		
		return cdao.findById(id).get();
	}

	@Override
	public Admin findOneByEmail(String email) {
		return (Admin) cdao.findOneByEmail(email);
	}

	@Override
	public Admin findOneByPhone(String phoneNumber) {
		return (Admin) cdao.findOneByPhone(phoneNumber);
	}

	@Override
	public void update(Admin admin) {
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

  
}
