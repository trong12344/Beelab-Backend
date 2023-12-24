<<<<<<< HEAD
//package com.Beelab.DAO;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//
//
//public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
//	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account  IN ?1")
//	List<Authority> authoritiesOf(List<Account> accounts);
//}
=======
package com.Beelab.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.Account;
import com.Beelab.Entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authoritiesOf(List<Account> accounts);
}
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
