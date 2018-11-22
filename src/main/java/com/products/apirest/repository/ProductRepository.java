package com.products.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.products.apirest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findById(long id);
	
	Product findByName(String name);
	
	@Query("SELECT p FROM Product p")
	List<Product> findAllProducts();
}
