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
//
//	public void sendMail(String userEmail, String toEmail, String subject, String body) {
//		log.info("Inside sendMail()");
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom(userEmail);
//		message.setTo(toEmail);
//		message.setSubject(subject);
//		message.setText(body);
//		javamailsender.send(message);
//		log.info("Mail sent successfylly");
//
//		try {
//			javamailsender.send(message);
//			log.info("Mail sent successfully");
//		} catch (Exception e) {
//			log.error("Error sending email: ", e);
//			throw new RuntimeException("Failed to send email", e);
//		}
//
//	}
	
	private final String targetEmail = "vamsireddy1717@gmail.com"; // Set your email here

    public void sendEmailFromUser(String Name, String Email, String subject, String Body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Email);
        message.setTo(targetEmail);
        message.setSubject(subject);
        message.setText("From: " + Name + "\nEmail: " + Email + "\n\n" +subject + message);

        javamailsender.send(message);
    }

}