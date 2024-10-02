package com.greetlabs.swiftcart.dto;


public class CartDto {
	private Integer productId;
    private Integer quantity;
	public CartDto(String userEmail, Integer productId, Integer quantity) {
		super();
	
		this.productId = productId;
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProduct(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    

}
