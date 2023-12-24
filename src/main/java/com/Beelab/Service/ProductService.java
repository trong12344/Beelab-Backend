package com.Beelab.Service;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

=======
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
import com.Beelab.Entity.Product;

public interface ProductService {
	public List<Product> findAll();

	public Product findById(Integer id);

<<<<<<< HEAD
	public List<Product> findByCategoryId(Integer cid);
=======
	public List<Product> findByCategoryId(String cid);
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8

	public Product create(Product product);

	public Product update(Product product);

	public void delete(Integer id);
<<<<<<< HEAD
	
	public List<Product> findBySupplierId(Integer cid);
	
	
=======
>>>>>>> 32190fa122a1cd1f838700e341b3ee62cafb17d8
}
