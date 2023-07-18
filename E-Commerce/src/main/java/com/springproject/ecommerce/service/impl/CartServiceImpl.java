package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.UserModel;
import com.springproject.ecommerce.repository.CartRepository;
import com.springproject.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public boolean saveCart(Cart cart) {
		
		cartRepo.saveAndFlush(cart);
		return true;
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		cartRepo.saveAndFlush(cart);
		return true;
	}

	@Override
	public Cart findCart(UserModel usermodel) {
		return usermodel.getCart();
	}

}
