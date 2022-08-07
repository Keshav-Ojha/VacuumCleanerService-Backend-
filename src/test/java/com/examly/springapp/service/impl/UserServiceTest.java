package com.examly.springapp.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.model.UserRegistrationForm;
import com.examly.springapp.service.UserService;

@SpringBootTest
@Transactional
class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	@DisplayName("Test to create a new user")
	void createUserTest() {
		UserRegistrationForm user = new UserRegistrationForm();
		user.setName("Steve Rogers");
		user.setEmail("steverogers@gmail.com");
		user.setMobileNumber("8888777766");
		user.setPassword("testpassword");
		
		String expected = "User created successfully";
		
		assertEquals(expected,userService.createUser(user),"Test failed for user creation");
		
	}
	

}
