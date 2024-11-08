package com.greetlabs.swiftcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.ContactDto;
import com.greetlabs.swiftcart.service.Impl.JwtService;
import com.greetlabs.swiftcart.service.Impl.MailService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/swift-cart")
//@Slf4j
public class ContactController {
	

    @Autowired
    private MailService mailService;
	
	@Autowired
	private JwtService jwtservice;
	
	@PostMapping("/send")
	public String sendmail(@RequestBody ContactDto contactDto,
			                                   @RequestHeader ("Authorization") String token){
		
		System.out.println(contactDto);
		System.out.println(token);
		
		String jwtToken = token.replace("Bearer ", "").trim();
		String userEmail=jwtservice.extractUserName(jwtToken);

		System.out.println(userEmail);
		 mailService.sendEmailFromUser(token, userEmail, jwtToken, userEmail);;
	     return "Email sent successfully!";
		
	}
	
}
