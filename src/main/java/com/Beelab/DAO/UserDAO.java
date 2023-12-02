package com.Beelab.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Beelab.Entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
