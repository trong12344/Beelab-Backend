package com.Beelab.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.RoleDAO;
import com.Beelab.Entity.Role;
import com.Beelab.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}
	
	
}
