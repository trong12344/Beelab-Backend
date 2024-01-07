package com.Beelab.Service;

import java.util.List;

import com.Beelab.Entity.Authority;


public interface AuthorityService {
	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);

//	public List<Authority> findAuthoritiesOfAdministrators();
}
