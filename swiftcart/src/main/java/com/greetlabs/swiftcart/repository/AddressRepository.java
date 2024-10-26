package com.greetlabs.swiftcart.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetlabs.swiftcart.entity.UserAddress;

import jakarta.mail.Address;

public interface AddressRepository extends JpaRepository<UserAddress, Long> {
	
//	 List<Address> findByUserId(Long userId);

}
