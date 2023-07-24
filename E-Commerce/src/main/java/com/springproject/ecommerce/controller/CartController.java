package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.service.CartService;
import com.springproject.ecommerce.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public CartService cartservice;
	
	@GetMapping("/home")
	public String getHome(@RequestParam int id, Model model,@ModelAttribute Cart cart,@ModelAttribute Product product) {
		
		
		double total = cart.getGrandTotal();
		double quantity = product.getProd_quantity();
		cart.setGrandTotal(total*quantity);
		
		cartservice.updateCart(cart);
		
		model.addAttribute("prodList", prodService.findProductById(id));
		
		return "shopping-cart";
	}
	


}
