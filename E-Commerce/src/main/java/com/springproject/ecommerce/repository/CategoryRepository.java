package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
