package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.Center;

public interface CenterRepository extends JpaRepository<Center, Long> {
}
