package com.bbbig.dto;

import com.bbbig.model.Review;

import java.time.LocalDateTime;

public record GetReviewDto(Long id, Long bookId, Double rating, String content, LocalDateTime createdAt,
                           LocalDateTime updatedAt) {
    public static GetReviewDto from(Review review) {
        return new GetReviewDto(review.getId(), review.getBookId(), review.getRating(), review.getContent(), review.getCreatedAt(), review.getUpdatedAt());
    }

}
