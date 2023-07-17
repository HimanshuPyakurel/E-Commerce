package com.springproject.ecommerce.service;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.UserModel;

public interface CartService {

	 boolean saveCart(Cart cart);

	 boolean updateCart(Cart cart);

	 Cart findCart(UserModel usermodel);

}
