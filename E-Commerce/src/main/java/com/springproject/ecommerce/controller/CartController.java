package com.springproject.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping("/home")
	public String getCart() {
		return "shopping-cart";
	}

}
