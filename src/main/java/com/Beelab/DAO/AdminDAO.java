package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Beelab.Entity.Admin;
import com.Beelab.Entity.Category;


public interface AdminDAO extends JpaRepository<Admin, Integer> {
	@Query("SELECT p FROM admin p WHERE p.email =?1")
	List<Admin> findOneByEmail(String email);
	
	@Query("SELECT p FROM admin p WHERE p.phone.number =?1")
	List<Admin> findOneByPhone(String phoneNumber);
	
}
