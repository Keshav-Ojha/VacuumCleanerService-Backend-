package com.examly.springapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.Users;
import com.examly.springapp.model.UserRegistrationForm;
import com.examly.springapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class UserController {
	
    @Autowired
    private UserService userService;

    // create user
    @PostMapping("/signup")
    public String createUser(@RequestBody UserRegistrationForm userRegForm) {
    	log.debug("User creation started. Details recived from user: {}", userRegForm);
        String message = userService.createUser(userRegForm);
        log.debug("New user created with details: {}",userRegForm);
        return message;
    }

    // Return all User
    @GetMapping("admin/allUser")
    public List<Users> getUser() {
        return this.userService.getUser();
    }

}
