package com.greetlabs.swiftcart.service;

import java.util.List;

import com.greetlabs.swiftcart.dto.UserAddressDTO;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.entity.UserAddress;

public interface AddressService {

	List<UserAddress> findByUserEmail(String userEmail);

	UserAddressDTO saveAddress(String UserEmail, UserAddressDTO address);
	
	 void deleteaddress(Long addressId);
	 
UserAddressDTO updateAddress(String name, String mobileNumber,Integer pinCode,String locality,String city, String state,String country);


}
