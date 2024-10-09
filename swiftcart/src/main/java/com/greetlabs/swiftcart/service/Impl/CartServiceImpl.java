package com.greetlabs.swiftcart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.CartResponseDto;
import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Cart;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.exception.RunTimeException;
import com.greetlabs.swiftcart.repository.CartRepository;
import com.greetlabs.swiftcart.repository.ProductRepository;

@Service
public class CartServiceImpl {
	
	@Autowired
	private CartRepository repo;
	
	@Autowired
	private ProductRepository prorepo;
	
	public CartResponseDto addToCart(String UserEmail, Integer productId, Integer quantity) {
	    
	    if (UserEmail == null || UserEmail.isEmpty()) {
	        throw new RuntimeException("Email cannot be null or empty");
	    }

	    
	    Product product = prorepo.findById(productId)
	            .orElseThrow(() -> new RuntimeException("Product Not Found"));

	    
	    Cart cartItem = new Cart();
	    cartItem.setUserEmail(UserEmail); 
	    cartItem.setProduct(product);
	    cartItem.setQuantity(quantity); 


	    repo.save(cartItem);

	  
	    CartResponseDto cartResponseDto = new CartResponseDto();
	    cartResponseDto.setCartId(cartItem.getCartId());
	    cartResponseDto.setEmail(cartItem.getUserEmail()); // Email should be properly set

	
	    ProductDto productDto = new ProductDto();
	    productDto.setId(product.getId());
	    productDto.setProductName(product.getProductName());
	    productDto.setPrice(product.getPrice());
	    productDto.setImageUrl(product.getImageUrl());
	    productDto.setDiscount(product.getDiscount());
	    productDto.setCategory(product.getCategory());
	    productDto.setDescription(product.getDescription());

	    cartResponseDto.setProductDto(productDto);
	    cartResponseDto.setQuantity(cartItem.getQuantity());

	    return cartResponseDto;
	}

	
	public List<Cart> getCartItems(String userEmail){

		return repo.findByuserEmail(userEmail);
	} 

	
	public void removeFromCart(int CartId) {
		repo.deleteById(CartId);
	}

}
