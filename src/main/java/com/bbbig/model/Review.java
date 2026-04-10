package com.bbbig.model;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Long bookId;
    private double rating;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Review(Long book_id, double rating, String content) {
        this.bookId = book_id;
        this.rating = rating;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }


    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public double getRating() {
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

