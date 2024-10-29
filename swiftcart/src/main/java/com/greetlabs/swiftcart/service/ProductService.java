package com.greetlabs.swiftcart.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Product;


import io.jsonwebtoken.io.IOException;

public interface ProductService {

	Product saveProduct(Product product);

	
	Product addProduct(ProductDto productDto)throws SQLException,IOException, java.io.IOException, Exception;

	List<ProductDto> getAllProducts();
	
	Optional<ProductDto> getProductById(int Id);
	
	Product updateProduct(int id, String productName, Double price, String imageUrl,Integer discount,String category,String description);
	
	String generateProductUrl(int id);

}
