package com.springproject.ecommerce.service;

import java.util.List;

import com.springproject.ecommerce.model.Address;

public interface AddressService {

	void addAddress(Address address);
	
	List<Address> findAddressByUserId(Long userId);
}
