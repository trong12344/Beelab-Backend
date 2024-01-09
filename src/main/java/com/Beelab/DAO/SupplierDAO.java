package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Size;
import com.Beelab.Entity.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDAO extends JpaRepository<Supplier, Integer>{
	@Query("SELECT p FROM Supplier p WHERE p.name=?1")
	List<Supplier> findOneByEmail(String email);
	@Query("SELECT s FROM Supplier s")
	List <Supplier> getListSupplier();
	Page<Supplier> findAll(Specification<Supplier> query, Pageable pageable);
}
