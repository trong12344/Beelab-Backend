package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Size;
import com.Beelab.Entity.Supplier;

public interface SupplierDAO extends JpaRepository<Supplier, Integer>{
	@Query("SELECT p FROM supplier p WHERE p.name=?1")
	List<Supplier> findOneByEmail(String email);



}
