package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springproject.ecommerce.model.Cart;
import com.springproject.ecommerce.model.CartLine;
import com.springproject.ecommerce.model.Product;
import com.springproject.ecommerce.service.CartLineService;
import com.springproject.ecommerce.service.CartService;
import com.springproject.ecommerce.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartLineService cartLineService;
	
	@Autowired
	public ProductService prodService;
	
	@Autowired
	public CartService cartservice;
	
	@GetMapping("/show")
	public String getHome(@RequestParam int id,@RequestParam(name = "result", required = false) String result) {
		
		ModelAndView modelAndView = new ModelAndView("page");

        if (result != null) {
            switch (result) {
                case "updated":
                    modelAndView.addObject("message", "CartLine has been updated sucessfully");
                    break;

                case "error":
                    modelAndView.addObject("message", "Something went wrong!!");
                    break;

                case "added":
                    modelAndView.addObject("message", "Cartline has been added sucessfully!");
                    break;

                case "deleted":
                    modelAndView.addObject("message", "Cart has been removed sucessfully");
                    break;
                default:
                    break;
            }
        }

        modelAndView.addObject("title", "User Cart");
        modelAndView.addObject("userClickShowCart", true);
        modelAndView.addObject("prodList", prodService.findProductById(id));
        modelAndView.addObject("cartLines", cartLineService.findCartLines());
        return "Cart";
	}
	
	 @GetMapping("/{id}/update")
	    public String updateCart(@PathVariable int id, @RequestParam int count) {
	        CartLine cartLine = cartLineService.findCartLineById(id);
	        if (cartLine != null) {
	            Product product = cartLine.getProduct();
	            double oldTotal = cartLine.getTotal();
	            if (product.getProd_quantity() <= count) {
	                count = product.getProd_quantity();
	            }
	            cartLine.setProductCount(count);
	            cartLine.setBuyingPrice(product.getProd_price());
	            cartLine.setTotal(product.getProd_price() * count);
	            String response = cartLineService.updateCartLine(cartLine) + "";
	            Cart cart = cartservice.findCart();
	            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
	            cartservice.updateCart(cart);
	            return "redirect:/cart/show?result=updated";
	        } else {
	            return "redirect:/cart/show?result=error";
	        }
	    }

	    @GetMapping("/{id}/delete")
	    public String deleteCart(@PathVariable int id) {
	        
	        CartLine cartLine = cartLineService.findCartLineById(id);
	        if (cartLine != null) {
	            Cart cart = cartservice.findCart();
	            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
	            cart.setCartLines(cart.getCartLines() - 1);
	            cartservice.updateCart(cart);

	            cartLineService.deleteCartLine(cartLine);
	            return "redirect:/cart/show?result=deleted";
	        } else {
	            return "redirect:/cart/show?result=error";
	        }
	    }

	    @GetMapping("/add/{id}/product")
	    public String addCart(@PathVariable int id) {
	        // TODO : fetch the cart
	        Cart cart = cartservice.findCart();
	        CartLine cartLine = cartLineService.findCartLineByCartIdAndProductId(cart.getId(), id);
	        if (cartLine != null) {

				/*cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
				cart.setCartLines(cart.getCartLines() - 1);
				cartService.updateCart(cart);
				// TODO : remove the cartLine
				cartLineService.deleteCartLine(cartLine);
				return "redirect:/cart/show?result=deleted";*/
	            return "";
	        } else {
	            cartLine = new CartLine();

	            Product product = prodService.findProductById(id);
	            cartLine.setCartId(cart.getId());
	            cartLine.setProduct(product);
	            cartLine.setBuyingPrice(product.getProd_price());
	            cartLine.setProductCount(1);
	            cartLine.setTotal(product.getProd_price());
	            cartLine.setAvailable(true);
	            cartLineService.saveCartLine(cartLine);
	            cart.setCartLines(cart.getCartLines() + 1);
	            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
	            cartservice.saveCart(cart);
	            return "redirect:/cart/show?result=added";
	        }
	    }

	}
