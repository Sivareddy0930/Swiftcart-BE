package com.greetlabs.swiftcart.service.Impl;



import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.exception.ProductNotFoundException;
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
	

	public Optional<ProductDto> getProductById(int id) {
	   
	    Optional<Product> product = repo.findById((int) id);

	 
	    return product.map(p -> new ProductDto(
                p.getId(),
	            p.getProductName(),
	            p.getPrice(),
	            p.getImageUrl(),
	            p.getDiscount(),
	            p.getCategory(),
	            p.getDescription()
	    ));
	}



	@Override
	 public List<ProductDto> getAllProducts() {
      
        List<Product> products = repo.findAll();
        
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
}

     
	 private ProductDto convertToDto(Product product) {
	        return new ProductDto(
	                product.getId(),
	                product.getProductName(),
	                product.getPrice(),
	                product.getImageUrl(),
	                product.getDiscount(),
	                product.getCategory(),
	                product.getDescription()
	        );
	    }


	@Override
	public Product updateProduct(int id, String productName, Double price, String imageUrl, Integer discount,
			String category, String description) {
		 Optional<Product> existingProductOptional = repo.findById(id);
	        
	        if (!existingProductOptional.isPresent()) {
	            throw new ProductNotFoundException("Product with ID " + id + " not found");
	        }
	        
	        Product existingProduct = existingProductOptional.get();
	        
	        existingProduct.setProductName(productName);
	        existingProduct.setPrice(price);
	        existingProduct.setImageUrl(imageUrl);  
	        existingProduct.setDiscount(discount);
	        existingProduct.setCategory(category);
	        existingProduct.setDescription(description);
	        
	        return repo.save(existingProduct);
	    }

	
	 private static final String BASE_URL = "https://swiftcart-backend-hcbccxbwhjb0b9fu.southindia-01.azurewebsites.net/swift-cart";
    
    @Override
	public String generateProductUrl(int id) {
		
		StringBuilder  urlBuilder=new StringBuilder(BASE_URL);
		
		urlBuilder.append("?id=").append(id);
		
		return urlBuilder.toString();
	}



//	@Override
//	public Product deleteProduct(int Id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//		public void deleteProduct(int id) {
//   		 Optional<Product> product = repo.findById(id);
//   		  if (!product.isPresent()) {
//     		   throw new ProductNotFoundException("Product with ID " + id + " not found");
//    		  }
//   		 repo.deleteById(id);
//		}




	}

