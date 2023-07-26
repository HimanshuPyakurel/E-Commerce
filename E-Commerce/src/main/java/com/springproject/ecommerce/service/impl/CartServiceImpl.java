package com.springproject.ecommerce.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.model.ShoppingCart;
import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.repository.CartRepository;
import com.springproject.ecommerce.repository.ShoppingCartRepository;
import com.springproject.ecommerce.service.ShoppingCartService;

@Service
public class CartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private CartRepository itemRepository;
	
	 @Autowired
	 private ShoppingCartRepository cartRepository;

	@Override
	public ShoppingCart addItemToCart(Product product, int quantity, User user) {
		
		ShoppingCart cart = user.getShoppingCart();

        if (cart == null) {
            cart = new ShoppingCart();
        }
        Set<Cart> cartItems = cart.getCartItem();
        Cart cartItem = findCartItem(cartItems, product.getId());
        if (cartItems == null) {
            cartItems = new HashSet<>();
            if (cartItem == null) {
                cartItem = new Cart();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getProd_price());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                itemRepository.save(cartItem);
            }
        } else {
            if (cartItem == null) {
                cartItem = new Cart();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getProd_price());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                itemRepository.save(cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + ( quantity * product.getProd_price()));
                itemRepository.save(cartItem);
            }
        }
        cart.setCartItem(cartItems);

        int totalItems = totalItems(cart.getCartItem());
        double totalPrice = totalPrice(cart.getCartItem());

        cart.setTotalPrices(totalPrice);
        cart.setTotalItems(totalItems);
        cart.setUser(user);

        return cartRepository.save(cart);

	}

	@Override
	public ShoppingCart updateItemInCart(Product product, int quantity, User user) {

		ShoppingCart cart = user.getShoppingCart();
        Set<Cart> cartItems = cart.getCartItem();

        Cart item = findCartItem(cartItems, product.getId());

        item.setQuantity(quantity);
        item.setTotalPrice(quantity * product.getProd_price());

        itemRepository.save(item);

        int totalItems = totalItems(cartItems);
        double totalPrice = totalPrice(cartItems);

        cart.setTotalItems(totalItems);
        cart.setTotalPrices(totalPrice);

        return cartRepository.save(cart);
	}

	@Override
	public ShoppingCart deleteItemFromCart(Product product, User user) {	
		
		ShoppingCart cart = user.getShoppingCart();
        Set<Cart> cartItems = cart.getCartItem();

        Cart item = findCartItem(cartItems, product.getId());

        cartItems.remove(item);
        itemRepository.delete(item);

        double totalPrice = totalPrice(cartItems);
        int totalItems = totalItems(cartItems);

        cart.setCartItem(cartItems);
        cart.setTotalItems(totalItems);
        cart.setTotalPrices(totalPrice);

        return cartRepository.save(cart);
        
	}
	
	
    private Cart findCartItem(Set<Cart> cartItems, Long productId) {
        if (cartItems == null) {
            return null;
        }
        Cart cartItem = null;

        for (Cart item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItem = item;
            }
        }
        return cartItem;
    }

    private int totalItems(Set<Cart> cartItems){
        int totalItems = 0;
        for(Cart item : cartItems){
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    private double totalPrice(Set<Cart> cartItems){
        double totalPrice = 0.0;

        for(Cart item : cartItems){
            totalPrice += item.getTotalPrice();
        }

        return totalPrice;
    }


	
	


}
