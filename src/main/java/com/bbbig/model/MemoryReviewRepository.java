package com.bbbig.model;

import com.bbbig.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryReviewRepository implements ReviewRepository {

    private List<Review> list = new ArrayList<>();
    private long id = 1L;

    @Override
    public Review save(Review review) {
        review.setId(id++);
        list.add(review);
        return review;
    }


    @Override
    public Optional<Review> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Review> findAll() {
        return list;
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}