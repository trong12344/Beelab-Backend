package com.Beelab.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Beelab.Entity.Color;

public interface ColorDAO extends  JpaRepository<Color ,Integer> {

}
