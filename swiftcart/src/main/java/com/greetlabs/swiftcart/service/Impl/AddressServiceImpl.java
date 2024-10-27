package com.greetlabs.swiftcart.service.Impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.UserAddressDTO;
import com.greetlabs.swiftcart.entity.Product;
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

	public void deleteaddress(Long addressId) {
		repo.deleteById(addressId);
	}

	
	public UserAddressDTO updateAddress( String name, String mobileNumber, Integer pinCode, String locality,
			String city, String state, String country) {
		
		UserAddressDTO userAddressDto=new UserAddressDTO();
		userAddressDto.setAddressId(userAddressDto.getAddressId());
		userAddressDto.setName(userAddressDto.getName());
		userAddressDto.setMobileNumber(userAddressDto.getMobileNumber());
		userAddressDto.setPinCode(userAddressDto.getPinCode());
		userAddressDto.setLocality(userAddressDto.getLocality());
		userAddressDto.setCity(userAddressDto.getCity());
		userAddressDto.setState(userAddressDto.getState());
		userAddressDto.setCountry(userAddressDto.getCountry());
		
		
		return userAddressDto;
	}

	

}
