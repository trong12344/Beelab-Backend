package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Beelab.Entity.Admin;


public interface AdminDAO extends JpaRepository<Admin, Integer> {
	
}
