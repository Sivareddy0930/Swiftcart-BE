package com.greetlabs.swiftcart.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.entity.User;
import com.greetlabs.swiftcart.repository.AddressRepository;
import com.greetlabs.swiftcart.repository.UserRepository;

@Service
public class AddressServiceImpl {
	
	
	@Autowired
	private AddressRepository repo;
	@Autowired
	private UserRepository userepo;
	
	
	 public Address addAddress(String Email, Address address) {
	        User user = userepo.findByUserEmail(Email).orElseThrow(() -> new RuntimeException("User not found"));
//	        address.
	        return repo.save(address);
	    }
	
}
