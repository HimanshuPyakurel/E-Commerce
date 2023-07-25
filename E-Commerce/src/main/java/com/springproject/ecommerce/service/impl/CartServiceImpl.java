package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.UserModel;
import com.springproject.ecommerce.repository.CartRepository;
import com.springproject.ecommerce.service.CartService;

import jakarta.servlet.http.HttpSession;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
    private HttpSession httpSession;
	
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
	public Cart findCart() {

		return ((UserModel) httpSession.getAttribute("userModel")).getCart();
	}

}
