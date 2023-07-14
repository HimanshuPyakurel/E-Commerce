package com.springproject.ecommerce.service;

import java.util.List;

import com.springproject.ecommerce.model.Product;

public interface ProductService {
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Long id);
	
	Product getProductById(Long id);
	
	List<Product> getAllProduct();
	
}
