package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.ShoppingCart;
import com.springproject.ecommerce.repository.CartRepository;
import com.springproject.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	public CartRepository cartRepo;
	
	@Override
	public ShoppingCart addItemToCart(Cart cart) {
		
		return null;
	}

	@Override
	public ShoppingCart updateItemInCart(Cart cart) {
		
		return null;
	}

	@Override
	public ShoppingCart deleteItemFromCart(int id) {
		
		return null;
	}


	


}
