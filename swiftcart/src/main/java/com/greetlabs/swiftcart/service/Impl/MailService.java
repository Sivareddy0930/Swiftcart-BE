package com.greetlabs.swiftcart.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.ContactDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {
	
	@Autowired
	JavaMailSender javamailsender;
	
	
	public MimeMessage sendMail(String from,String to,String subject,String body) {
//		log.info("Inside sendMail()");
//		SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        javamailsender.send(message);
//        log.info("Mail sent successfylly");
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
		return createMimeMessage;
	}

}
