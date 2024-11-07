package com.greetlabs.swiftcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="UserAddress")
@AllArgsConstructor
@NoArgsConstructor
	
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
		
	private String name;
	
	private String mobileNumber;
	
	private Integer pinCode;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private String country;
	
	//@ManyToOne	
	//@JoinColumn(name = "userEmail",nullable = false)
	private String userEmail;
	
	 
}
