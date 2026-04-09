package com.bbbig.repository;

import com.bbbig.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    Review save(Review review);

    Optional<Review> findById(Long id);

    List<Review> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
