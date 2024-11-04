package com.greetlabs.swiftcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String sendcontactform(@RequestBody ContactDto contactdto) {
		
		String fromEmail="your_email@example.com";
		String tomail="ck124418@gmail.com";
		String subject="Contact Form" + contactdto.getSubject();
		String body="Name"+contactdto.getName()+
				    "Email"+contactdto.getEmail()+
				    "Message"+contactdto.getMessage();
		
		service.sendMail(fromEmail, tomail, subject, body);
		return "Message Sent SucessFully";
	}

}
