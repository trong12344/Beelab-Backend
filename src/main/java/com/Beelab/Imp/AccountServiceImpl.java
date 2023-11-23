package com.Beelab.Imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.AccountDAO;
import com.Beelab.Entity.Account;
import com.Beelab.Service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO adao;
	
	@Override
	public Account findById(String username) {
		return adao.findById(username).get();
	}

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}
}
