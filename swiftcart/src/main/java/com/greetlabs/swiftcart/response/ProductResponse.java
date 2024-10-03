package com.greetlabs.swiftcart.response;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
	
	   private int id;
	    private String productName;
	    private double price;
	    private String imageUrl;
	    private Integer discount;
	    private String category;
	    private String description;
	    public ProductResponse(int id, String productName,  double price, String imageUrl,Integer discount,String category,String description) {
	        this.id = id;
	        this.productName = productName;
	        this.price = price;
	        this.imageUrl=imageUrl;
	        this.discount=discount;
	        this.category=category;
	        this.description=description;
	    }

}
