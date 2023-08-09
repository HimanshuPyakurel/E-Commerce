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
import org.springframework.web.multipart.MultipartFile;
import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.service.CategoryService;
import com.springproject.ecommerce.service.ProductService;
import com.springproject.ecommerce.utils.FileUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	private FileUtil fileUtils;
	
	@Autowired
	public CategoryService catService;

	@GetMapping("/add")
	public String addProduct(Model model) {
		
		model.addAttribute("catlist",catService.getAllCategory());
		return "productadd";
	}
	
	@PostMapping("/add")
	public String postProduct(@ModelAttribute Product product, @RequestParam MultipartFile image, Model model) {
		
		if(!image.isEmpty()) {
					
					String imageName = image.getOriginalFilename();
					product.setImageName(imageName);
					fileUtils.imageUpload(image);
					
					prodService.addProduct(product);
					
					model.addAttribute("message", "Product added successfully !!");
					return "redirect:/product/add";		
		}
		return "productadd";
		
	}
	
	@GetMapping("/list")
	public String getProductList(Model model) {
		model.addAttribute("prodlist",prodService.findAllProduct());
		return "productlist";	
	}
	
	 @GetMapping("/delete")
	 public String delete(@RequestParam int id) {
		 	
		 	prodService.deleteProduct(id);
		 
		 return "redirect:/product/list";
	 }
	 
	 @GetMapping("/edit")
		public String editEmp(@RequestParam int id, Model model) {

			model.addAttribute("prodObject", prodService.findProductById(id));
			model.addAttribute("catlist",catService.getAllCategory());
			
			return "productEdit";
		}
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Product product, @RequestParam MultipartFile image, Model model) {
		 
		 if(!image.isEmpty()) {
				
				String imageName = image.getOriginalFilename();
				product.setImageName(imageName);
				fileUtils.imageUpload(image);
				
				prodService.updateProduct(product);
				
				model.addAttribute("message", "Product added successfully !!");
				return "redirect:/product/list";		
	}
		 return "productEdit";
		
	 }
	 
	 @GetMapping("/view")
	 public String view(@RequestParam int id, Model model) {
		 
		 model.addAttribute("prodObject",prodService.findProductById(id));
		 model.addAttribute("catObject", catService.getAllCategory());
		 
		 return "productView";
	 }
	 
	 @GetMapping("/find")
	 public String findProductById(@RequestParam Long id, Model model){
		 		
		 List<Product> products = prodService.findProductByCategoryId(id);
	     
	     model.addAttribute("prodlist", products);
	     model.addAttribute("catlist",catService.getAllCategory());
	        
	     return "shop";
	     
	    }
	 
	 
}	
	
	