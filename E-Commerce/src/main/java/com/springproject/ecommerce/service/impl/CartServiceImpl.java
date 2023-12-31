package com.springproject.ecommerce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.repository.CartRepository;
import com.springproject.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	@Override
	public void addItemToCart(List<Cart> cart) {

		cartRepo.saveAll(cart);	
	}

	@Override
	public void updateItemInCart(List<Cart> cart) {

		cartRepo.saveAll(cart);
		
	}

	@Override
	public void deleteItemFromCart(Cart cart) {
		
		cartRepo.delete(cart);
		
	}

	@Override
	public List<Cart> findAllCart() {
		
		return cartRepo.findAll();
	}
	

	


	


}
