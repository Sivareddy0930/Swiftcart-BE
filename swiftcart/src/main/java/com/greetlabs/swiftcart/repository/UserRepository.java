package com.greetlabs.swiftcart.repository;


import com.greetlabs.swiftcart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserEmail(String email);

	Optional<User> findByUserMobile(Long mobile);

	@Query(value = "SELECT U.FIRST_NAME, U.LAST_NAME, U.USER_MOBILE, U.ALTER_MOBILE, U.USER_EMAIL, UA.PIN_CODE, UA.LOCALITY, UA.CITY, UA.STATE, UA.COUNTRY FROM USERS U INNER JOIN USER_ADDRESS UA ON U.USER_EMAIL=UA.USER_EMAIL", nativeQuery = true)
//	@Query(value = "SELECT * FROM USERS U INNER JOIN USER_ADDRESS UA ON U.USER_EMAIL=UA.USER_EMAIL", nativeQuery = true)
	List<Object> getProfileData(@Param("userEmail") String userEmail);

}
