package com.greetlabs.swiftcart.service.Impl;



import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.repository.ProductRepository;
import com.greetlabs.swiftcart.service.ProductService;

import io.jsonwebtoken.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product addProduct(ProductDto productDto) throws SQLException, IOException, java.io.IOException, Exception {
		 Product product = new Product();
		    product.setProductName(productDto.getProductName());
		    product.setPrice(productDto.getPrice());
		    product.setImageUrl(productDto.getImageUrl());
		    product.setDiscount(productDto.getDiscount());
		    product.setCategory(productDto.getCategory());
		    product.setDescription(productDto.getDescription());

		
		    return repo.save(product);
	}
	

	@Override
	public Product saveProduct(Product product) {
		return repo.save(product);
	}






}
