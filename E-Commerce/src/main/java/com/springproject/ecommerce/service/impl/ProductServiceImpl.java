package com.springproject.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.repository.ProductRepository;
import com.springproject.ecommerce.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodRepo; 
	
	@Override
	public void addProduct(Product product) {
		prodRepo.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		prodRepo.deleteById(id);
	}

	@Override
	public List<Product> getAllProduct() {
			
		return prodRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		
		return prodRepo.findById(id).get();
	}

	@Override
	public void updateProduct(Product product) {
		prodRepo.save(product);
		
	}

}
