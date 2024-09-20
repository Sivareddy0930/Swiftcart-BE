package com.greetlabs.swiftcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetlabs.swiftcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
