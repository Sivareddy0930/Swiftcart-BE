package com.greetlabs.swiftcart.response;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
	
	   private int Id;
	    private String ProductName;
	    private double Price;
	    private String photo;
	    private Integer Discount;
	    private String Category;
	    private String Discription;
	    public ProductResponse(int Id, String ProductName,  double Price, byte[] photoBytes,Integer Disocunt,String Category,String Discription) {
	        this.Id = Id;
	        this.ProductName = ProductName;
	        this.Price = Price;
	        this.photo=photo;
	        this.Discount=Discount;
	        this.Category=Category;
	        this.Discription=Discription;
	    }

}
