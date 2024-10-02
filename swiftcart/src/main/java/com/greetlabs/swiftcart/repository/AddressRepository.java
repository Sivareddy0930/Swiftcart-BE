package com.greetlabs.swiftcart.repository;


import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greetlabs.swiftcart.entity.UserAddress;

public interface AddressRepository extends JpaRepository<UserAddress, Long> {


	Address save(Address address);

}
