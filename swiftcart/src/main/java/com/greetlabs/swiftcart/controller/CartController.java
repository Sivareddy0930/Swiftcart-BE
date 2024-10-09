package com.greetlabs.swiftcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greetlabs.swiftcart.dto.CartDto;
import com.greetlabs.swiftcart.dto.CartResponseDto;
import com.greetlabs.swiftcart.entity.Cart;
import com.greetlabs.swiftcart.repository.CartRepository;
import com.greetlabs.swiftcart.service.Impl.CartServiceImpl;
import com.greetlabs.swiftcart.service.Impl.JwtService;




@RestController
@RequestMapping("/swift-cart")
public class CartController  {
	
	@Autowired
	private CartServiceImpl service;
	
	@Autowired
	private JwtService jwtservice;
	
	@Autowired
	private CartRepository repo;
//	
//	@GetMapping("/get")
//	public String name() {
//		return "working";
//	}
	
	@PostMapping("/cart/addtocart")
	public ResponseEntity<CartResponseDto> addTOCart(@RequestBody CartDto cartDto,
										  @RequestHeader ("Authorization") String token){
		
		
		System.out.println(cartDto);
		System.out.println(token);
		
		String jwtToken = token.replace("Bearer ", "").trim();
		String userEmail=jwtservice.extractUserName(jwtToken);

		System.out.println(userEmail);
	
		CartResponseDto cartItem=service.addToCart(userEmail,cartDto.getProductId(),cartDto.getQuantity());
		
		return ResponseEntity.ok(cartItem);
		
	}
	
	
	@GetMapping("/items")
	public List<Cart> getCartItems(@RequestParam("userEmail") String userEmail){
//		List<Cart> cartItems = service.getCartItems(userEmail);
		return repo.findByuserEmail(userEmail);
	}
	
	
	@DeleteMapping("/remove/{CartId}")
	public ResponseEntity<Void> removeFromCart(@PathVariable int CartId){
		service.removeFromCart(CartId);
		return ResponseEntity.noContent().build();
	}

}
