package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}

