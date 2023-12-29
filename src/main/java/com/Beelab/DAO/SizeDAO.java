package com.Beelab.DAO;

import java.util.List;

import com.Beelab.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Product;
import com.Beelab.Entity.Size;

public interface SizeDAO extends JpaRepository<Size, Integer> {
	@Query("SELECT p FROM Size p WHERE p.name=?1")
	List<Size> findOneByName(String name);

	Page<Size> findAll(Specification<Size> query, Pageable pageable);





}
