package com.greetlabs.swiftcart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
	
    private Long id;
	
	private String name;
	
	private String email;
	
	private String subject;
	
	private String message;
	


}
