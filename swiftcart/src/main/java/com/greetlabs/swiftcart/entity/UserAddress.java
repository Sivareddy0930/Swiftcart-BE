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
	private Long AddressId;
		
	private String Name;
	
	private String MobileNumber;
	
	private Integer PinCode;
	
	private String Locality;
	
	private String City;
	
	private String State;
	
	private String Country;
	
//	@ManyToOne	
	@JoinColumn(name = "userEmail",nullable = false)
	private String userEmail;
}
