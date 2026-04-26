package com.bbbig.model;

import com.bbbig.dto.UpdateDto;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Long bookId;
    private Double rating;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void update(UpdateDto updateDto) {
        if (updateDto.rating() != null) {
            checkRating(updateDto.rating());
            this.rating = updateDto.rating();
        }
        if (updateDto.content() != null) {
            checkContent(updateDto.content());
            this.content = updateDto.content();
        }
        this.updatedAt = LocalDateTime.now();
    }

    public Review(Long bookId, Double rating, String content) {
        checkRating(rating);


        this.bookId = bookId;
        this.rating = rating;
        this.content = checkContent(content);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }


    public void assignId(Long id) {
        if (this.id != null) {
            throw new IllegalArgumentException("id가 이미 있드아!!");
        }
        this.id = id;
    }


    private void checkRating(Double rating) {
        if (rating == null || rating < 1.0 || rating > 5.0) {
            throw new IllegalArgumentException("평점은 1~5점 사이여야 합니다");
        }
    }

    private String checkContent(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("리뷰 내용은 비우면 안됩니다");
        }
        String trimcontent = content.trim();
        if (trimcontent.length() > 50) {
            throw new IllegalArgumentException("리뷰 내용은 50글자를 초과해서 안됩니다");
        }
        return trimcontent;
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


}

