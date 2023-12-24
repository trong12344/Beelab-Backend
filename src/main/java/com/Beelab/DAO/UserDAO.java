package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Supplier;
import com.Beelab.Entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	
	@Query("SELECT p FROM User p WHERE p.phone_number=?1")
	User findByPhone(String phoneNumber);

	@Query("SELECT p FROM User p WHERE p.full_name=?1")
	User findByUserName(String fullName);
	

	@Query("SELECT p FROM User p WHERE p.email=?1")
	User findByGmail(String email);
//
//	@Query("SELECT DISTINCT ar.account  FROM Authority ar WHERE ar.role.id IN ('DIRE', 'STAF')")
//	List<Account> getAdministrators();

}
