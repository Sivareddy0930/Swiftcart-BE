package com.greetlabs.swiftcart.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender javamailsender() {
		
		 JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.example.com"); // Replace with your SMTP host
	        mailSender.setPort(587); // Replace with your SMTP port

	        mailSender.setUsername("vamsireddy1717@gmail.com"); // Your email
	        mailSender.setPassword("dsza buph pdfj azgw"); // Your email password

	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

		return mailSender;
		
	}
	

}
