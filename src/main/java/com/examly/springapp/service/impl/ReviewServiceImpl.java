package com.examly.springapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Review;
import com.examly.springapp.exceptions.BusinessException;
import com.examly.springapp.repo.ReviewRepository;
import com.examly.springapp.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        this.reviewRepository.save(review);
        return review;
    }

    @Override
    public Review deleteReview(long id) {
    	Optional<Review> optional = reviewRepository.findById(id);
    	Review deletedReview = optional.orElseThrow(()-> new BusinessException("Review with id "+id+" was not found."));
    	reviewRepository.delete(deletedReview);
        return deletedReview;
    }

    @Override
    public Review editReview(Review review, long id) {

        Optional<Review> tmp = reviewRepository.findById(id);

        Review myReview = tmp.orElseThrow(() -> new RuntimeException("No such data found"));

        myReview.setReviewContent(review.getReviewContent());

        reviewRepository.save(myReview);

        return myReview;
    }

    @Override
    public List<Review> fetchReviewsByCenterId(long centerId) {
        return this.reviewRepository.findByCenterServiceCenterId(centerId);
    }

}
