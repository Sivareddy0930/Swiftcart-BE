package com.greetlabs.swiftcart.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.response.ProductResponse;

import io.jsonwebtoken.io.IOException;

public interface ProductService {

	Product saveProduct(Product product);

	
	Product addProduct(ProductDto productDto)throws SQLException,IOException, java.io.IOException, Exception;
//
//	List<ProductResponse> getAllProducts();
//	
//	Optional<ProductDto> getProductById(int Id);
//	
//	 byte[] getPhotoByProductId(int Id) throws SQLException;
//	
////	Product updateProduct(int Id, String ProductName, Double Price, byte[] photoBytes,Integer Disocunt,String Category,String Discription);
//
//	 void deleteProduct(int Id);
//
//	Product updateProduct(int Id, String ProductName, Double Price, byte[] photoBytes, Integer Disocunt,
//			String Category, String Discription);
}
