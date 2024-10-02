package com.greetlabs.swiftcart.dto;

import com.greetlabs.swiftcart.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CartResponseDto {
	private int CartId;
	private String Email;
    private ProductDto productDto;
	private Integer quantity;

}
