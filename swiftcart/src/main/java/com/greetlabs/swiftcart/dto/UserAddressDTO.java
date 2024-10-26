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


//	public Long getAddressId() {
//		return addressId;
//	}
//
//
//	public UserAddressDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public void setAddressId(Long addressId) {
//		this.addressId = addressId;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//
//	public Integer getPinCode() {
//		return pinCode;
//	}
//
//
//	public void setPinCode(Integer pinCode) {
//		this.pinCode = pinCode;
//	}
//
//
//	public String getLocality() {
//		return locality;
//	}
//
//
//	public void setLocality(String locality) {
//		this.locality = locality;
//	}
//
//
//	public String getCity() {
//		return city;
//	}
//
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//
//	public String getState() {
//		return state;
//	}
//
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//
//	public String getCountry() {
//		return country;
//	}
//
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//
//	public String getUserEmail() {
//		return userEmail;
//	}
//
//
//	public void setUserEmail(String userEmail) {
//		this.userEmail = userEmail;
//	}
//	

	

}
