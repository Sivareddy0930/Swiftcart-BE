package com.greetlabs.swiftcart.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {

	@Autowired
	private JavaMailSender javamailsender;

	public void sendMail(String userEmail, String toEmail, String subject, String body) {
		log.info("Inside sendMail()");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(userEmail);
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		javamailsender.send(message);
		log.info("Mail sent successfylly");

		try {
			javamailsender.send(message);
			log.info("Mail sent successfully");
		} catch (Exception e) {
			log.error("Error sending email: ", e);
			throw new RuntimeException("Failed to send email", e);
		}

	}

}