package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.Contact;
import com.springproject.ecommerce.repository.ContactRepository;
import com.springproject.ecommerce.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@Override
	public void addContact(Contact contact) {
		contactRepo.save(contact);
	}

	
	
	
}
