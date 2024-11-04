package com.greetlabs.swiftcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greetlabs.swiftcart.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
