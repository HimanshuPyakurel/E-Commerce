package com.springproject.ecommerce.service;

import com.springproject.ecommerce.model.Address;

public interface AddressService {

	boolean saveAddress(Address address);

    Address findAddressByBilling(boolean billing);
}
