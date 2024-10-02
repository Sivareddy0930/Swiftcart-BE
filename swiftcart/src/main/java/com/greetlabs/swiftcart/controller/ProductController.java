package com.greetlabs.swiftcart.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.service.ProductService;



@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/swift-cart")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add-new-product")
	 public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) throws SQLException, IOException, Exception{

	      Product product= service.addProduct(productDto);

	      return ResponseEntity.ok(product);
	}
		
}
	
	


