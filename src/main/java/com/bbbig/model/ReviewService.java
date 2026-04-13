package com.bbbig.model;

import com.bbbig.repository.ReviewRepository;

public class ReviewService {
    private final ReviewRepository repository;


    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public void createReview(Long bookId, double rating, String content) {
        
        Review newReview = new Review(bookId, rating, content);
        repository.save(newReview);
    }

}
