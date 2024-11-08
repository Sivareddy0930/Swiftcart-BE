package com.greetlabs.swiftcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.ContactDto;
import com.greetlabs.swiftcart.service.Impl.JwtService;
import com.greetlabs.swiftcart.service.Impl.MailService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;

//import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/swift-cart")
//@Slf4j
public class ContactController {
	

    @Autowired
    private MailService mailService;
	
	@Autowired
	private JwtService jwtservice;
	
//	@PostMapping("/send")
//	public String sendmail(@RequestBody ContactDto contactDto,
//			                                   @RequestHeader ("Authorization") String token){
//		
//		System.out.println(contactDto);
//		System.out.println(token);
//		
//		String jwtToken = token.replace("Bearer ", "").trim();
//		String userEmail=jwtservice.extractUserName(jwtToken);
//
//		System.out.println(userEmail);
//		 mailService.sendEmailFromUser(contactDto.getName(), contactDto.getEmail(),contactDto.getSubject(),contactDto.getMessage());;
//	     return "Email sent successfully!";
//		
//	}
	
    @PostMapping("/send")
    public String sendEmailToAdmin(@RequestBody ContactDto contactdto, @RequestHeader ("Authorization") String token) {


        // Extract email from the token
        String senderEmail = jwtservice.extractUserName(token);

         mailService.sendEmailFromUser(contactdto,senderEmail);
        return "Email sent successfully!";
    }
}
