package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
