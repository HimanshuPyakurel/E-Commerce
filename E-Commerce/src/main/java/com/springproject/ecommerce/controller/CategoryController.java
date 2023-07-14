package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.Category;
import com.springproject.ecommerce.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryservice;
	
	@GetMapping("/add")
	public String getcatAdd() {	
		return "categoryadd";
	}
	
	@PostMapping("/add")
	public String getcatAdd(@ModelAttribute Category category) {
		
		categoryservice.addCategory(category);
		return "categoryadd";
	}
	
	@GetMapping("/list")
	public String getProductList(Model model) {
		
		model.addAttribute("catlist",categoryservice.getAllCategory());
		return "categorylist";	
	}
	
	 @GetMapping("/delete")
	 public String delete(@RequestParam long id) {
		 	
		 	categoryservice.deleteCategory(id);
		 
		 return "redirect:/category/list";
	 }
	 
	 @GetMapping("/edit")
		public String editEmp(@RequestParam long id, Model model) {

			model.addAttribute("catObject", categoryservice.getCategoryById(id));
			
			return "categoryEdit";
		}
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Category cat) {
		 
		 categoryservice.updateCategory(cat);
		 
		 return "redirect:/category/list"; 
	 }
	 
}

