package com.greetlabs.swiftcart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.UserAddressDTO;
import com.greetlabs.swiftcart.entity.UserAddress;
import com.greetlabs.swiftcart.service.Impl.AddressServiceImpl;
import com.greetlabs.swiftcart.service.Impl.JwtService;


@RestController
@RequestMapping("/swift-cart")
public class UserAddressController {
	
	@Autowired
	private AddressServiceImpl service;
	
	@Autowired
	private JwtService jwtservice;
	
	@PostMapping("/addAddress")
	public ResponseEntity<UserAddressDTO> saveAddress(@RequestBody UserAddressDTO useraddressdto,
													  @RequestHeader ("Authorization") String token){
		
		
		String jwtToken = token.replace("Bearer ", "").trim();
		String userEmail=jwtservice.extractUserName(jwtToken);

		System.out.println(userEmail);
		
		UserAddressDTO saveAddress=service.saveAddress(userEmail, useraddressdto);
		
		return new ResponseEntity<>(saveAddress,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/address")
	public List<UserAddress> getadddress(@RequestHeader ("Authorization") String token){
		
		String jwtToken = token.replace("Bearer ", "").trim();
		String userEmail=jwtservice.extractUserName(jwtToken);

		return service.findByUserEmail(userEmail);
	}
	
	@DeleteMapping("/delete/{addressId}")
	public ResponseEntity<Void> deleteaddress(@PathVariable Long addressId){
		service.deleteaddress(addressId);
		return ResponseEntity.noContent().build();
	}
}
 

