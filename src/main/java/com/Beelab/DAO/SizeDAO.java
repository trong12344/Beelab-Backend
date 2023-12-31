package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Product;
import com.Beelab.Entity.Size;

public interface SizeDAO extends JpaRepository<Size, Integer> {

	
	@Query("SELECT p FROM size p WHERE p.name=?1")
	List<Size> findOneByName(String name);
}
