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
@Table(name="AddTOCart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
//	@ManyToOne	
	@JoinColumn(name = "userEmail",nullable = false)
	private String userEmail;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
    private Product product;
	
	private Integer quantity;

}
