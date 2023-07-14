package com.springproject.ecommerce.controller;

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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public CategoryService catService;

	@GetMapping("/add")
	public String addProduct(Model model) {
		
		model.addAttribute("catlist",catService.getAllCategory());
		return "productadd";
	}
	
	@PostMapping("/add")
	public String postProduct(@ModelAttribute Product product) {
		
		prodService.addProduct(product);
	
		return "redirect:/product/add";
	}
	
	@GetMapping("/list")
	public String getProductList(Model model) {
		model.addAttribute("prodlist",prodService.getAllProduct());
		return "productlist";	
	}
	
	 @GetMapping("/delete")
	 public String delete(@RequestParam long id) {
		 	
		 	prodService.deleteProduct(id);
		 
		 return "redirect:/product/list";
	 }
	 
	 @GetMapping("/edit")
		public String editEmp(@RequestParam long id, Model model) {

			model.addAttribute("prodObject", prodService.getProductById(id));
			model.addAttribute("catlist",catService.getAllCategory());
			
			return "productEdit";
		}
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Product prod) {
		 
		 prodService.updateProduct(prod);
		 
		 return "redirect:/product/list"; 
	 }
	 
	 @GetMapping("/view")
	 public String view(@RequestParam long id, Model model) {
		 
		 model.addAttribute("prodObject",prodService.getProductById(id));
		 model.addAttribute("catObject", catService.getCategoryById(id));
		 
		 return "productView";
	 }
	
}	
	
	