

package com.Beelab.DAO;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Beelab.Entity.ProductDetail;

public interface ProductDetailDAO extends JpaRepository<ProductDetail, Integer> {
	@Query("SELECT p FROM ProductDetail p WHERE p.product.id=?1")
	List<ProductDetail>  getProductDetail(Integer cid);

	@Query(value = "select * from product_detail po where po.product_id = ?1 and po.color_id = ?2 and po.size_id = ?3 order by po.color_id desc limit 1", nativeQuery = true)
	Optional<ProductDetail> findFirstByProductIdAndColorIdAndSize(Integer productId, Integer colorId, Integer size);
}
