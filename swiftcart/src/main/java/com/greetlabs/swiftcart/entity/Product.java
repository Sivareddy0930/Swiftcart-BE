package com.greetlabs.swiftcart.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name="product_details")
@AllArgsConstructor
@NoArgsConstructor	
public class Product {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String productName;
	
	private double price;
	
	private String imageUrl;
	
	private Integer discount;
	
	private String category;
	
	private String description;
	

}
