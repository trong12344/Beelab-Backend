package com.Beelab.Service;


import java.util.List;

import com.Beelab.Entity.Account;


public interface AccountService {
	public List<Account> findAll();

	public Account findById(String username);

	public List<Account> getAdministrators();
}
