package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    boolean existsUserByEmail(String email);

    boolean existsUserByMobileNumber(String mobileNumber);

    Users findByEmail(String username);
}
