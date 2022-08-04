package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.entity.Users;
import com.examly.springapp.model.UserRegistrationForm;

public interface UserService {
    public String createUser(UserRegistrationForm userRegForm);

    public List<Users> getUser();
}
