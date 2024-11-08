package com.greetlabs.swiftcart.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.ProfileDto;
import com.greetlabs.swiftcart.entity.User;
import com.greetlabs.swiftcart.entity.UserAddress;
import com.greetlabs.swiftcart.repository.AddressRepository;
import com.greetlabs.swiftcart.repository.UserRepository;

@Service
public class ProfileServiceImpl {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private AddressRepository addressrepo;
	
	
	public ProfileDto updateprofile(ProfileDto profiledto) {
		
		 User user = userrepo.findById(profiledto.getId())
	                .orElseThrow(() -> new RuntimeException("User not found"));
		 
		 user.setFirstName(profiledto.getFirstName());
		 user.setLastName(profiledto.getLastName());
		 user.setUserMobile(profiledto.getUserMobile());
		 user.setAlterMobile(profiledto.getAlterMobile());
		 user.setUserEmail(profiledto.getUserEmail());
		 
		 UserAddress useraddress=addressrepo.findById(profiledto.getAdressId())
				 .orElseThrow(()->new RuntimeException());
		 
		 useraddress.setPinCode(profiledto.getPinCode());
		 useraddress.setLocality(profiledto.getLocality());
		 useraddress.setCity(profiledto.getCity());
		 useraddress.setState(profiledto.getState());
		 useraddress.setCountry(profiledto.getCountry());
		 
		
		return profiledto;
		
	}
	

}
