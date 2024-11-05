package com.greetlabs.swiftcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.ContactDto;
import com.greetlabs.swiftcart.service.Impl.MailService;



@RestController
@RequestMapping("/swift-cart")
public class ContactController {
	
	@Autowired
	private MailService service;
	
	
	
	@PostMapping("/contact")
	public ResponseEntity<String> sendContactForm(
	        @RequestBody ContactDto contactDto,
        @RequestHeader("Authorization") String token) {
	    
   
	    System.out.println("Received Contact DTO: " + contactDto);
	    System.out.println("Received Token: " + token);

	    String jwtToken = token.replace("Bearer ", "").trim();
	    
	    String toEmail = "vanukurivamsikrishna@gmail.com";
	    String subject = "Contact Form: " + contactDto.getSubject();
	    String body = String.format("Name: %s\nEmail: %s\nMessage: %s", 
	                                 contactDto.getName(), 
                                 contactDto.getEmail(), 
	                                 contactDto.getSubject(),
	                                 contactDto.getMessage());
	    try {
	    
	        service.sendMail(jwtToken, toEmail, subject, body);
	        return ResponseEntity.ok("Message sent successfully!");
	    } catch (Exception e) {
	    
	        System.err.println("Error sending email: " + e.getMessage());	        
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Error sending message: " + e.getMessage());
	    }
	}
}
	
	