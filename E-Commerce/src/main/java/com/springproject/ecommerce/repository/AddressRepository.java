package com.springproject.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

	List<Address> findAddressByUserId(Long userId);
}
