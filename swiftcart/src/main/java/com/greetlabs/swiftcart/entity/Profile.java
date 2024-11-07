package com.greetlabs.swiftcart.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "user_profile")
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;
	private String firstName;
	private String lastName;
	private Long userMobile;
	private Long alterMobile;
	private String userEmail;

}
