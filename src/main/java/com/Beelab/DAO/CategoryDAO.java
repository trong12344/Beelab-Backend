package com.Beelab.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.Beelab.Entity.Category;
import com.Beelab.Entity.ProductDetail;
public interface CategoryDAO extends JpaRepository<Category, Integer>  {
	@Query("SELECT p FROM Category p WHERE p.name =?1")
	List<Category> findOneByName(String name);
	

}
