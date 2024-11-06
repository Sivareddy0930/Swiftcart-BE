//package com.greetlabs.swiftcart.controller;
//
//import java.nio.charset.StandardCharsets;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.greetlabs.swiftcart.dto.ContactDto;
//import com.greetlabs.swiftcart.service.Impl.JwtService;
//import com.greetlabs.swiftcart.service.Impl.MailService;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/swift-cart")
//@Slf4j
//public class ContactController {
//
//	@Autowired
//	private MailService service;
//	
//    @Autowired
//    private JwtService jwtUtil;
//
//	@PostMapping("/contact")
//	public ResponseEntity<String> sendContactForm(@RequestBody ContactDto contactDto,
//			@RequestHeader("Authorization") String token) {
//
//		System.out.println("Received Contact DTO: " + contactDto);
//		System.out.println("Received Token: " + token);
//
//		String jwtToken = token.replace("Bearer ", "").trim();
//		String userEmail = jwtUtil.extractEmail(jwtToken);
//		log.info("From mail:{}",jwtToken);
//		String toEmail = contactDto.getEmail();
//		String subject = "Contact Form: " + contactDto.getName() + contactDto.getEmail() + contactDto.getSubject()
//				+ contactDto.getMessage();
//		String body = String.format("Name: %s\nEmail: %s\nSubject: %s\nMessage", contactDto.getName(),
//				contactDto.getEmail(), contactDto.getSubject(), contactDto.getMessage());
//		try {
//
//			service.sendMail(jwtToken, toEmail, subject, body);
//			return ResponseEntity.ok("Message sent successfully!");
//		} catch (Exception e) {
//
//			System.err.println("Error sending email: " + e.getMessage());
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//					.body("Error sending message: " + e.getMessage());
//		}
//		
//	}
//	 public String extractEmail(String token) {
//	        Claims claims = Jwts.builder()
//	                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
//	                .build()
//	                .parseClaimsJws(token)
//	                .getBody();
//	        return claims.getSubject();
//	    }
//}
