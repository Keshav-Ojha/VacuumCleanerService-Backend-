package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.entity.Review;

import javax.transaction.Transactional;
import java.util.*;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findByCenterServiceCenterId(long centerId);

    @Transactional
    void deleteByCenterServiceCenterId(long centerId);
}
