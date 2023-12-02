

package com.Beelab.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.ProductDetail;

public interface ProductDetailDAO extends JpaRepository<ProductDetail, Integer> {
	@Query("SELECT p FROM ProductDetail p WHERE p.product.id=?1")
	List<ProductDetail>  getProductDetail(Integer cid);
}
