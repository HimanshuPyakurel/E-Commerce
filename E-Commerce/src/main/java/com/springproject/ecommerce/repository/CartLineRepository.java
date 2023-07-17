package com.springproject.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.CartLine;

public interface CartLineRepository extends JpaRepository<CartLine, Integer>{

	List<CartLine> findCartLineByCartId(int cartId);

    CartLine findCartLineByCartIdAndProductId(int cartId, int id);
}
