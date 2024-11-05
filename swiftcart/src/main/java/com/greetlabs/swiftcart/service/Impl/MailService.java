package com.greetlabs.swiftcart.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {
	
	@Autowired
	private JavaMailSender javamailsender;
	
	
	public void sendMail(String from,String to,String subject,String body) {
		log.info("Inside sendMail()");
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vamsireddy1717@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javamailsender.send(message);
        log.info("Mail sent successfylly");
	}
	
	
	}
