package com.springproject.ecommerce.service;

import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.model.ShoppingCart;
import com.springproject.ecommerce.model.User;

public interface ShoppingCartService {

	ShoppingCart addItemToCart(Product product, int quantity, User user);

	ShoppingCart updateItemInCart(Product product, int quantity, User user);

	ShoppingCart deleteItemFromCart(Product product, User user);
	 

}
