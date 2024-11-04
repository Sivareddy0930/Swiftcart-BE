package com.greetlabs.swiftcart.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender javamailsender;
	
	
	public void sendMail(String from,String to,String subject,String body) {
		MimeMessage  createMimeMessage=javamailsender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper =new MimeMessageHelper(createMimeMessage,true);
			mimeMessageHelper.setTo(from);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
			javamailsender.send(createMimeMessage);
		}
		catch(MessagingException e) {
			e.printStackTrace();
			
		}
	}

}
