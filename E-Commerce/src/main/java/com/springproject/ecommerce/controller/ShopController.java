package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.ecommerce.service.CategoryService;
import com.springproject.ecommerce.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public CategoryService categoryservice;
	
	@GetMapping("/index")
	public String getshop(Model model) {
		model.addAttribute("prodlist",prodService.findAllProduct());
		model.addAttribute("catlist",categoryservice.getAllCategory());
		return "shop";
	}
	
}
