package com.greetlabs.swiftcart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greetlabs.swiftcart.service.UserService;


@RestController
@RequestMapping("/swift-cart")
public class ProfileController {
	
	private static final Logger log = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private UserService userService;
	
	 @GetMapping("/profile/{userEmail}")
	    public List<Object> getUserProfile(@PathVariable String userEmail) {	
	     log.info("Request received for profile date");
		 List<Object> profileData = userService.getProfileData(userEmail);
		 log.info("Profile data found:{}",profileData);
		 return profileData;
	    }
	

}
