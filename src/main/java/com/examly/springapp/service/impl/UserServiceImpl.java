package com.examly.springapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Users;
import com.examly.springapp.exceptions.BusinessException;
import com.examly.springapp.model.UserRegistrationForm;
import com.examly.springapp.repo.UserRepository;
import com.examly.springapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String createUser(UserRegistrationForm form) {
    	
    	if(form.getEmail() == null || form.getEmail().equals("")) {
    		throw new BusinessException("Username cannot be null or empty");
    	}
    	
    	if(form.getPassword() == null || form.getPassword().equals("")) {
    		throw new BusinessException("Password cannot be null or empty");
    	}
    	
        boolean emailAlreadyExists = userRepository.existsUserByEmail(form.getEmail());
        boolean mobileAlreadyExists = userRepository.existsUserByMobileNumber(form.getMobileNumber());

        if (emailAlreadyExists) {
            return "Email id already exists";
        }
        if (mobileAlreadyExists) {
            return "Mobile number already exists";
        }
        
        Users user = new Users();
        user.setName(form.getName());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setEmail(form.getEmail());
        user.setMobileNumber(form.getMobileNumber());
        user.setActive(true);
        user.setRoles("ROLE_USER");
        
        try {
            userRepository.save(user);
            return "User created successfully";
        } catch (Exception e) {
            throw new BusinessException("Unwanted Exception occurred: \n" + e);
        }
    }

    // return all user details
    @Override
    public List<Users> getUser() {
        return this.userRepository.findAll();
    }
    
}
