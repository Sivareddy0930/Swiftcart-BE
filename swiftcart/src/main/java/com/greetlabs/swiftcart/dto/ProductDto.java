package com.greetlabs.swiftcart.dto;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
	@Id
	private int id;
    private String productName;
    private double price;
//    private String photoBase64;
    private String imageUrl;
    private Integer discount;
    private String category;
    private String description;


}
