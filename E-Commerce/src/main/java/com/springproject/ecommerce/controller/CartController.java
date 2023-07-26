package com.springproject.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.service.ShoppingCartService;
import com.springproject.ecommerce.service.CategoryService;
import com.springproject.ecommerce.service.IUserService;
import com.springproject.ecommerce.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public IUserService userservice;
	
	@Autowired
	public ShoppingCartService cartservice;
	
	@Autowired
	public CategoryService categoryservice;
	
	@GetMapping("/show")
	public String getHome(Model model,@ModelAttribute Product product,@RequestParam int id) {
		
		model.addAttribute("prodlist",prodService.findProductById(id));
		model.addAttribute("catlist",categoryservice.getAllCategory());
		
		
		
		Cart cart = new Cart();
		double total = cart.getQuantity() * product.getProd_price();;
		
		return "Cart";
	}
	
	@PostMapping("/show")
	public String postHome(Model model,@RequestParam int id, @ModelAttribute Cart cart) {
		Product product = new Product();
		model.addAttribute("prodlist",prodService.findProductById(id));
		model.addAttribute("catlist",categoryservice.getAllCategory());
		
		
		return "Cart";
	}
	
}