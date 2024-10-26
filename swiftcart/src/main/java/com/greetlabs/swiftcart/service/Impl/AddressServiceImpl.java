package com.greetlabs.swiftcart.service.Impl;



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
	public UserAddressDTO saveAddress(UserAddressDTO address) {
		
//		 User user = userepo.findById(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
		
		
		 
//	    if (UserEmail == null || UserEmail.isEmpty()) {
//	        throw new RuntimeException("Email cannot be null or empty");
//	    }
//
//	    
//	    Product product = prorepo.findById(productId)
//	            .orElseThrow(() -> new RuntimeException("Product Not Found"));

		
		UserAddress useraddress=new UserAddress(
				address.getAddressId(),
				address.getName(),
				address.getMobileNumber(),
				address.getPinCode(),
				address.getLocality(),
				address.getCity(),
				address.getState(),
				address.getCountry(),
				address.getUserEmail()
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
	
	
}
