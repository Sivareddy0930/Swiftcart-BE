package com.greetlabs.swiftcart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetlabs.swiftcart.dto.CartResponseDto;
import com.greetlabs.swiftcart.dto.ProductDto;
import com.greetlabs.swiftcart.entity.Cart;
import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.entity.User;
import com.greetlabs.swiftcart.exception.RunTimeException;
import com.greetlabs.swiftcart.repository.CartRepository;
import com.greetlabs.swiftcart.repository.ProductRepository;
import com.greetlabs.swiftcart.repository.UserRepository;

@Service
public class CartServiceImpl {
	
	@Autowired
	private CartRepository repo;
	
	@Autowired
	private ProductRepository prorepo;
	
	@Autowired
	private UserRepository userepo;
	public CartResponseDto addToCart(String Email,Integer productId,Integer quantity ) {
//		User user1= Us.orElseThrow(()->new RunTimeException("User Not Found"));
		Product product=prorepo.findById(productId).orElseThrow(()->new RunTimeException("Product Not Found"));
		
		 Cart cartItem = new Cart();
	        cartItem.setUserEmail(Email);
	        cartItem.setProduct(product);
	        cartItem.setQuantity(quantity);
	        repo.save(cartItem);
	        
	        CartResponseDto cartResponseDto = new CartResponseDto();
	        cartResponseDto.setCartId(cartItem.getCartId());
	        cartResponseDto.setEmail(cartItem.getUserEmail());
	        
	        // Create DTO to return
	        ProductDto ProductDto = new ProductDto();
	        ProductDto.setId(product.getId());
	        ProductDto.setProductName(product.getProductName());
	        ProductDto.setPrice(product.getPrice());
	        ProductDto.setImageUrl(product.getImageUrl()); 
	        ProductDto.setDiscount(product.getDiscount());
	        ProductDto.setCategory(product.getCategory());
	        ProductDto.setDescription(product.getDescription());

	        
	        cartResponseDto.setProductDto(ProductDto);
	        cartResponseDto.setQuantity(cartItem.getQuantity());
	        
	        return cartResponseDto;
	    }
	
	
	public List<Cart> getCartItems(String email){
//		User user = userepo.findByUserEmail(email).orElseThrow(()->new RunTimeException("User Not Found"));
		return repo.findByUserEmail(email);
	} 

	
	public void removeFromCart(int CartId) {
		repo.deleteById(CartId);
	}

}
