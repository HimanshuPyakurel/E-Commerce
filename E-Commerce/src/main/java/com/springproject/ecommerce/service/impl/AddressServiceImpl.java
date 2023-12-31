package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.ecommerce.model.Address;
import com.springproject.ecommerce.repository.AddressRepository;
import com.springproject.ecommerce.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public void addAddress(Address address) {
		addressRepo.save(address);
		
	}


}
