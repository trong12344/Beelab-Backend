package com.Beelab.DAO;

import com.Beelab.Entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {

	@Query("SELECT p FROM User p WHERE p.phone_number=?1")
	User findByPhone(String phoneNumber);

	@Query("SELECT p FROM User p WHERE p.full_name=?1")
	User findByUserName(String fullName);

	@Query("SELECT p FROM User p WHERE p.email like :email")
	User findByEmail(String email);
	@Query("SELECT u FROM User u")
	List<User> getListUser();

	Page<User> findAll(Specification<User> query, Pageable pageable);
}
