package com.springproject.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.service.IUserService;
import com.springproject.ecommerce.utils.MailUtils;
import com.springproject.ecommerce.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MailUtils mailutils;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session, @RequestParam("g-recaptcha-response") String grcCode) throws IOException {
			
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			User  usr = userService.login(user.getUname(), user.getPassword());
			System.out.println("=========="+usr);
				if(usr != null) {
					log.info("---------- Login Success ---------");
					
					session.setAttribute("validuser", usr);
					session.setMaxInactiveInterval(200);
					
					//model.addAttribute("user",usr);
					return "Home";
				}else {
					log.info("---------- Login Failed ---------");
					model.addAttribute("message","User not Found!!!");
					return  "login";
				}
				
				
			}
	
	@GetMapping("/signup")
	public String getSingup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model) {
		
		log.info("---------- SignUp Success ---------");
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.signup(user);
		model.addAttribute("message1","Signup Successful");
		return "login";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		
		log.info("---------- User logout Success ---------");
		
		session.invalidate();	//session kill
		
		return "login";
	}
	
	@GetMapping("/forget")
	public String getForget() {
		
		return "ForgetPassword";
	}
	
	@PostMapping("/forget")
	public String postForgetpwd(@RequestParam String toEmail) {
		mailutils.forgetpwdEmail(toEmail);
		return "login";
	}
	

}