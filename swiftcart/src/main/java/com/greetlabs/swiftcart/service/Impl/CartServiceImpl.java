//package com.greetlabs.swiftcart.service.Impl;
//
//import java.io.IOException;
//import java.sql.Blob;
//import java.sql.SQLException;
//import java.util.Base64;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.greetlabs.swiftcart.dto.CartResponseDto;
//import com.greetlabs.swiftcart.dto.ProductDto;
//import com.greetlabs.swiftcart.entity.Cart;
//import com.greetlabs.swiftcart.entity.Product;
//import com.greetlabs.swiftcart.exception.ResourceNotFoundException;
//import com.greetlabs.swiftcart.exception.RunTimeException;
//import com.greetlabs.swiftcart.repository.CartRepository;
//import com.greetlabs.swiftcart.repository.ProductRepository;
//import com.greetlabs.swiftcart.repository.UserRepository;
//
//@Service
//public class CartServiceImpl {
//	
//	@Autowired
//	private CartRepository repo;
//	
//	@Autowired
//	private ProductRepository prorepo;
//	
//	@Autowired
//	private UserRepository userepo;
//	
//    private byte[] convertBlobToBytes(Blob blob) throws SQLException {
//        if (blob == null) {
//            return null;
//        }
//        return blob.getBytes(1, (int) blob.length());
//    }
//
//	
//	
//	public CartResponseDto addToCart(String Email,Integer productId,Integer quantity ) {
////		User user1= Us.orElseThrow(()->new RunTimeException("User Not Found"));
//		Product product=prorepo.findById(productId).orElseThrow(()->new RunTimeException("Product Not Found"));
//		
//		 Cart cartItem = new Cart();
//	        cartItem.setEmail(Email);
//	        cartItem.setProduct(product);
//	        cartItem.setQuantity(quantity);
//	        repo.save(cartItem);
//	        
//	        CartResponseDto cartResponseDto = new CartResponseDto();
//	        cartResponseDto.setCartId(cartItem.getCartId());
//	        cartResponseDto.setEmail(cartItem.getEmail());
//	        
//	       Product productFromCart =  cartItem.getProduct();
//	        String base64Image = null;
//
//	        try {
//	            Blob photoBlob = productFromCart.getPhoto();
//	    	    
//	    	  	byte[] imageBytes = convertBlobToBytes(photoBlob);
//	    	     base64Image = Base64.getEncoder().encodeToString(imageBytes);
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//
//	        // Create DTO to return
//	        ProductDto ProductDto = new ProductDto();
//	        ProductDto.setId(product.getId());
//	        ProductDto.setProductName(product.getProductName());
//	        ProductDto.setPrice(product.getPrice());
//	        ProductDto.setPhotoBase64(base64Image);  // Set Base64 encoded image
//	        ProductDto.setDiscount(product.getDisocunt());
//	        ProductDto.setCategory(product.getCategory());
//	        ProductDto.setDescription(product.getDiscription());
//	        ProductDto.setStockQuantity(product.getStockQuantity());
//
//	        
//	        cartResponseDto.setProductDto(ProductDto);
//	        cartResponseDto.setQuantity(cartItem.getQuantity());
//	        
//	        return cartResponseDto;
//	    }
//	
//	
////	public List<Cart> getCartItems(Long id){
////		User user = userepo.findById(id).orElseThrow(()->new RunTimeException("User Not Found"));
////		return repo.findByUser(user);
////	} 
//
//	
////	public void removeFromCart(int CartId) {
////		repo.deleteById(CartId);
////	}
//}
