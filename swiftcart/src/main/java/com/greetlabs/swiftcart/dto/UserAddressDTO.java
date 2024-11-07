package com.greetlabs.swiftcart.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDTO {

	private Long addressId;

	private String name;

	private String mobileNumber;

	private Integer pinCode;

	private String locality;

	private String city;

	private String state;

	private String country;

	private String userEmail;



}
