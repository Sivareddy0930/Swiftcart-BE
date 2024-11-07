package com.greetlabs.swiftcart.service;

import java.util.List;


import com.greetlabs.swiftcart.dto.UserDto;

public interface UserService {
    String createUser(UserDto userDto);
    
	List<Object> getProfileData(String userEmail);

}
