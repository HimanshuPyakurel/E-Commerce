package com.springproject.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.Address;
import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.service.AddressService;
import com.springproject.ecommerce.service.CartService;
import com.springproject.ecommerce.service.IUserService;
import com.springproject.ecommerce.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public IUserService userservice;
	
	@Autowired
	public CartService cartservice;
	
	@Autowired
	public AddressService addressservice;
	
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		
    	model.addAttribute("total",total(session));
		return "Cart"; 
	}
	
    @GetMapping("/add")
    public String addCart(@RequestParam int id,HttpSession session, Model model)
    {   
    	if(session.getAttribute("cart")==null) {
    		
        	List<Cart> cart = new ArrayList<>();    	
        	cart.add(new Cart(1,prodService.findProductById(id)));        	
        	session.setAttribute("cart",cart);
    		
    	}else {
    		List<Cart> cart = (List<Cart>) session.getAttribute("cart");
    		int index = isExists(id, cart);
    		
    		if(index == -1) {
    			cart.add(new Cart(1,prodService.findProductById(id)));
    		}else {
    			int quantity = cart.get(index).getQuantity() +1;
    			cart.get(index).setQuantity(quantity);
    		}
    		session.setAttribute("cart",cart);
    	} 
    	
    	model.addAttribute("total",total(session));
             
        return "Cart";
    }
	
    @GetMapping("/delete")
    public String deletecart(@RequestParam int id,HttpSession session,Model model)
    {
    	List<Cart> cart = (List<Cart>) session.getAttribute("cart");
		int index = isExists(id, cart);
    	cart.remove(index);
    	session.setAttribute("cart",cart);	
    	model.addAttribute("total",total(session));
		return "Cart";
    
    }
    
    @PostMapping("/update")
    public String updatecart(HttpServletRequest request,HttpSession session,Model model)
    {
    	String[] quantity = request.getParameterValues("quantity");
    	List<Cart> cart = (List<Cart>) session.getAttribute("cart");
    	
    	for(int i=0;i<cart.size();i++) {
    		cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
    	}
    	session.setAttribute("cart",cart);
    	model.addAttribute("total",total(session));
		return "Cart";
    
    }
    
    @GetMapping("/checkout")
    public String Checkoutcart(HttpSession session,@ModelAttribute User user,Model model)
    {
		User  usr = userservice.login(user.getUname(), user.getPassword());
    	if(usr != null) {
    		return "login";
    	}else { 		
    		List<Cart> cart = (List<Cart>) session.getAttribute("cart");
    		cartservice.addItemToCart(cart);
    		model.addAttribute("total",total(session));
    		return "checkout";
    	}	
    
    }
    
    @PostMapping("/checkout")
    public String Checkoutcart(@ModelAttribute Address address){
    	
    	addressservice.addAddress(address);
		return "cart";
    }
      
    private int isExists(int id, List<Cart> cart) {
    	for(int i=0; i<cart.size();i++) {
    		if(cart.get(i).getProduct().getId() == id) {
    			return i;   			
    		}
    	}
    	return -1;   	
    }
    
    private double total(HttpSession session) {    	
    	List<Cart> cart = (List<Cart>) session.getAttribute("cart");
    	double s = 0;
    	for(Cart item: cart) {
    		
    		s+= item.getQuantity() * item.getProduct().getProd_price().doubleValue();
    		
    	}	
    	return s;
    }
    
       
    
    
    
}