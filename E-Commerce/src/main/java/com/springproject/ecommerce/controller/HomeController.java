package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.ecommerce.service.ProductService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	public ProductService prodService;
	
	@GetMapping("/index")
	public String home(Model model) {
		
		model.addAttribute("prodlist",prodService.findAllProduct());
		return "Home";
	}
}
