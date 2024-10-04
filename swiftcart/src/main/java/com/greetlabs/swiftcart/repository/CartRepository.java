package com.greetlabs.swiftcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetlabs.swiftcart.entity.Cart;
import com.greetlabs.swiftcart.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByUser(User user);

}
