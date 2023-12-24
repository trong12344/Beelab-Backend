package com.Beelab.Imp;


import java.util.List;

import com.Beelab.DAO.UserDAO;
import com.Beelab.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.AuthorityDAO;
import com.Beelab.Entity.Authority;
import com.Beelab.Service.AuthorityService;



@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO dao;
	@Autowired
	UserDAO acdao;

//	@Override
//	public List<Authority> findAuthoritiesOfAdministrators() {
////		List<User> accounts = acdao.getAdministrators();
////		return dao.authoritiesOf(accounts);
//
//	}

	@Override
	public List<Authority> findAll() {
		return dao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return dao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}
	
	
	
}
