package com.bbbig.model;

import java.time.LocalDateTime;

public class Review {
    private long id;
    private long book_id;
    private double rating;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Review(long book_id, double rating, String content) {
        this.book_id = book_id;
        this.rating = rating;
        this.content = content;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();

    }


    public long getId() {
        return id;
    }

    public long getBook_id() {
        return book_id;
    }

    public double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setId(long id) {
        this.id = id;
    }
}

