package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

	 Address findAddressByBilling(boolean billing);
}
