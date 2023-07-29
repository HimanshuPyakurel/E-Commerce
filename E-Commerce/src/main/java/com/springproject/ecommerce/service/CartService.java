package com.springproject.ecommerce.service;

import java.util.List;

import com.springproject.ecommerce.model.Cart;

public interface CartService {

	void addItemToCart(List<Cart> cart);

	void updateItemInCart(List<Cart> cart);

	void deleteItemFromCart(int id);

}
