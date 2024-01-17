package com.Beelab.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Beelab.Entity.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleDAO extends JpaRepository<Role, String> {
    @Query("select p from Role p where p.normalizedName = ?1")
    Optional<Role> findByName(String name);
}
