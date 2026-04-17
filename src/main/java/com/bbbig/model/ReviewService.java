package com.bbbig.model;

import com.bbbig.repository.ReviewRepository;

import java.util.List;

public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review createReview(Long bookId, Double rating, String content) {
        Review newReview = new Review(bookId, rating, content);
        return repository.save(newReview);
    }

    public Review findReview(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다"));
    }

    public List<Review> findAllReview() {
        return repository.findAll();
    }

    public Review update(Long id, UpdateDto updateDto) {
        Review update = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다"));

        update.updatDto(updateDto);
        return repository.save(update);
    }

    public void deleteReview(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다"));
        repository.deleteById(id);

    }
}
