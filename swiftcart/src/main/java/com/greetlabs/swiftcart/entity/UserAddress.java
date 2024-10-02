package com.greetlabs.swiftcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Address Table")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AddressId;
		
	private String Name;
	
	private String MobileNumber;
	
	private Integer PinCode;
	
	private String Locality;
	
	private String Address;
	
	private String City;
	
	private String State;
	
	private String Country;
	

	
    private String Email;
	
}
