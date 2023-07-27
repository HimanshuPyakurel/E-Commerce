package com.springproject.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findProductByCategoryId(Long categoryId);
}
