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
import com.springproject.ecommerce.model.Product;
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
	
	 @GetMapping("/find")
	 public String findProductById(@RequestParam Long id, Model model){
		 		
		 List<Product> products = prodService.findProductByCategoryId(id);
	     
	     model.addAttribute("prodlist", products);
	     model.addAttribute("catlist",categoryservice.getAllCategory());
	        
	     return "shop";
	     
	    }
	 
	 @PostMapping("/search")
	 public String SearchProduct(@ModelAttribute String search, Model model) {
		 
		 List<Product> products = prodService.findProductByName(search);
		 model.addAttribute("prodlist", products);
		 return "shop";
	 }
	 
	
}
