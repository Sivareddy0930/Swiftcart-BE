package com.greetlabs.swiftcart.service.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.UserAddressDTO;
import com.greetlabs.swiftcart.entity.UserAddress;
import com.greetlabs.swiftcart.repository.AddressRepository;
import com.greetlabs.swiftcart.service.AddressService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceImpl implements AddressService {
	
	
	@Autowired
	private AddressRepository repo;
	
	@Override
	public UserAddressDTO saveAddress(String UserEmail, UserAddressDTO userAddressDto) {
		
            
		
		UserAddress useraddress=new UserAddress(
				userAddressDto.getAddressId(),
				userAddressDto.getName(),
				userAddressDto.getMobileNumber(),
				userAddressDto.getPinCode(),
				userAddressDto.getLocality(),
				userAddressDto.getCity(),
				userAddressDto.getState(),
				userAddressDto.getCountry(),
				UserEmail
				
				);
		      
		
		
		UserAddress saveAddress=repo.save(useraddress);	
		
		UserAddressDTO addressDTO=new UserAddressDTO(
				saveAddress.getAddressId(),
				saveAddress.getName(),
				saveAddress.getMobileNumber(),
				saveAddress.getPinCode(),
				saveAddress.getLocality(),
				saveAddress.getCity(),
				saveAddress.getState(),
				saveAddress.getCountry(),
				saveAddress.getUserEmail()
				);
		
		
		return addressDTO;
	    
		

	}

	@Override
	public List<UserAddress> findByUserEmail(String userEmail) {
		return repo.findByUserEmail(userEmail);
	}


}
