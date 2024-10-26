package com.greetlabs.swiftcart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserAddressDTO {
	
	private Long AddressId;
	
	private String Name;
	
	private String MobileNumber;
	
	private Integer PinCode;
	
	private String Locality;
	
	private String City;
	
	private String State;
	
	private String Country;
	

    private String userEmail;

}
