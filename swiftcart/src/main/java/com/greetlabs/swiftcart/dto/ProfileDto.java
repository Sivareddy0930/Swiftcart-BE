package com.greetlabs.swiftcart.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

	private Long profileId;
	private String firstName;
    private String lastName;
    private Long userMobile;
    private Long alterMobile;
    private String userEmail;
    private List<UserAddressDTO> addresses;
	public void setAddresses(Integer pinCode, String locality, String city, String state, String country) {
		// TODO Auto-generated method stub
		
	}

}
