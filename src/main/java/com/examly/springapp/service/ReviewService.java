package com.examly.springapp.service;

import java.util.*;

import com.examly.springapp.entity.Review;

public interface ReviewService {

    public Review addReview(Review review);

    public Review deleteReview(long id);

    public Review editReview(Review review, long id);

    public List<Review> fetchReviewsByCenterId(long centerId);
}
