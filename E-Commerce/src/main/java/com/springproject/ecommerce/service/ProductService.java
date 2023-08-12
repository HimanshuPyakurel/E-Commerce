package com.springproject.ecommerce.service;

import java.util.List;

import com.springproject.ecommerce.model.Product;

public interface ProductService {
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(int id);
	
	Product findProductById(int id);
	
	List<Product> findAllProduct();
	
	List<Product> findAllProductsForAdmin();

	List<Product> findProductByCategoryId(Long categoryId);

	Product findProductByIdForAdmin(int id);

	List<Product> findProductByName(String productname);
	    

	    
	
}
