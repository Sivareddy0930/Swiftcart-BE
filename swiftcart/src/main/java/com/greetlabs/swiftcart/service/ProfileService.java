package com.greetlabs.swiftcart.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.ProfileDto;
import com.greetlabs.swiftcart.dto.UserAddressDTO;
import com.greetlabs.swiftcart.entity.User;
import com.greetlabs.swiftcart.entity.UserAddress;
import com.greetlabs.swiftcart.repository.AddressRepository;
import com.greetlabs.swiftcart.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfileService {
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired	
	private AddressRepository useraddressrepo;
	
	public ProfileDto getuserprofile(Long id) {
		
		User user =userrepository.findById(id).orElseThrow(()->new RuntimeException());
		Optional<UserAddress> addresses = useraddressrepo.findById(id);
		
		ProfileDto profileDto=new ProfileDto();
		profileDto.setProfileId(user.getId());
		profileDto.setFirstName(user.getFirstName());
		profileDto.setLastName(user.getLastName());
		profileDto.setUserMobile(user.getUserMobile());
		profileDto.setAlterMobile(user.getAlterMobile());
		profileDto.setUserEmail(user.getUserEmail());
		profileDto.setAddresses(
				addresses.stream().<UserAddressDTO>map(address -> {
	                UserAddressDTO addressDto=new UserAddressDTO();
	                addressDto.setPinCode(addressDto.getPinCode());
	                addressDto.setLocality(addressDto.getLocality());
	                addressDto.setCity(addressDto.getCity());
	                addressDto.setState(addressDto.getState());
	                addressDto.setCountry(addressDto.getCountry());
	                addressDto.setName(addressDto.getName());
	                addressDto.setUserEmail(addressDto.getUserEmail());
	                return addressDto;
	            }).collect(Collectors.toList())
				);
				       
		return profileDto;
		
	}
}
