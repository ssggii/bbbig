package com.bbbig.model;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private final Long bookId;
    private Double rating;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void updateDto(Double rating, String content) {
        checkRating(rating);
        checkConten(content);

        this.rating = rating;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public Review(Long bookId, Double rating, String content) {
        checkRating(rating);
        checkConten(content);

        this.bookId = bookId;
        this.rating = rating;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    private void checkRating(Double rating) {
        if (rating == null || rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("평점은 1~5점 사이여야 합니다");
        }
    }

    private void checkConten(String content) {
        if (content == null || content().isBlank() || content.length() > 50) {
            throw new IllegalArgumentException("리뷰 내용은 비우거나 50글자를 초과해서 안됩니다");
        }
    }


    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public Double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

