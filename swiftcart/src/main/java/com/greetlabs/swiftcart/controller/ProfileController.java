package com.greetlabs.swiftcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.ProfileDto;
import com.greetlabs.swiftcart.service.ProfileService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/swift-cart")
@AllArgsConstructor
@NoArgsConstructor
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	 @GetMapping("/profile/{userId}")
	    public ProfileDto getUserProfile(@PathVariable Long userId) {
	        return service.getuserprofile(userId);
	    }
	

}
