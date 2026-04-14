package com.bbbig.model;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private final Long bookId;
    private Double rating;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Review(Long bookId, Double rating, String content) {
        if (rating == null || rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("평점은 1~5점 사이여야 합니다");
        }
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("리뷰 내용 비울수 없습니다");
        }

        if (content.length() > 50) {
            throw new IllegalArgumentException("리뷰 내용은 50자를 초과할 수 없습니다");
        }
        this.bookId = bookId;
        this.rating = rating;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
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

