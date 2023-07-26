package com.springproject.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.Product;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	public List<Cart> findByProduct(Product product);
	
}
