package com.springproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.ecommerce.model.Contact;
import com.springproject.ecommerce.service.ContactService;
import com.springproject.ecommerce.utils.MailUtils;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactservice;
	
	@Autowired
	private MailUtils mailutils;
	
	@GetMapping("/home")
	public String getContact() {
		return "contact";
	}
	
	@PostMapping("/mail")
	public String postmail(@RequestParam String fromEmail,@RequestParam String toEmail,@RequestParam  String name,@RequestParam  String message,@ModelAttribute Contact contact) {
		mailutils.sendEmail(fromEmail,toEmail,name,message);
		contactservice.addContact(contact);
		return "contact";
	}
	@PostMapping("/first")
	public String postfirstmail(@RequestParam String fromEmail,@RequestParam String toEmail) {
		mailutils.sendEmailBymail(fromEmail,toEmail);
		return "contact";
	}
	
}
