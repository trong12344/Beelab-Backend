package com.Beelab.DAO;

import java.util.List;

import com.Beelab.Entity.Authority;
import com.Beelab.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account  IN ?1")
	List<Authority> authoritiesOf(List<User> accounts);
}