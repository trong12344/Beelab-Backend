package com.Beelab.DAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import com.Beelab.Entity.Category;
import com.Beelab.Entity.ProductDetail;
public interface CategoryDAO extends JpaRepository<Category, Integer>  {
	@Query("SELECT p FROM Category p WHERE p.name =?1")
	List<Category> findOneByName(String name);


	@Query("SELECT s FROM Category s")
	List<Category> getListCategory();

	//List<Category> findCategoriesByIdGreaterThan(int lastCategoryId, PageRequest of);
	Page<Category> findAll(Specification<Category> query, Pageable pageable);

}
