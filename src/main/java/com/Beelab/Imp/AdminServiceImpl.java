package com.Beelab.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.AdminDAO;
import com.Beelab.Entity.Admin;
import com.Beelab.Service.AdminService;

import java.util.Date;

@Service 
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin changePassword() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Admin updateAdmin(Admin admin) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Admin findOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findOneByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findOneByPhone(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

  
}
