package com.springproject.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.CartLine;
import com.springproject.ecommerce.repository.CartLineRepository;
import com.springproject.ecommerce.service.CartLineService;
import com.springproject.ecommerce.service.CartService;

@Service
public class CartLineServiceImpl implements CartLineService{

	@Autowired
    private CartService cartService;
	
	@Autowired
    private CartLineRepository cartlineRepo;
	
	@Override
	public CartLine findCartLineById(int id) {
		
		return cartlineRepo.findById(id).get();
	}

	@Override
	public boolean saveCartLine(CartLine cartLine) {
		cartlineRepo.save(cartLine);
		return true;
	}

	@Override
	public boolean updateCartLine(CartLine cartLine) {
		cartlineRepo.save(cartLine);
		return true;
	}

	@Override
	public boolean deleteCartLine(CartLine cartLine) {
		cartlineRepo.delete(cartLine);
		return false;
	}

	@Override
	public List<CartLine> findAllCartLine(int cartId) {
		
		return cartlineRepo.findAll();
	}

	@Override
	public List<CartLine> findCartLines() {
		Cart cart = cartService.findCart();
		return cartlineRepo.findCartLineByCartId(cart.getId());
	}

	@Override
	public CartLine findCartLineByCartIdAndProductId(int cartId, int id) {
		
		return cartlineRepo.findCartLineByCartIdAndProductId(cartId, id);
	}

}
