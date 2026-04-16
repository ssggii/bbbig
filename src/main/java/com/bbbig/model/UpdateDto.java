package com.bbbig.model;

public class UpdateDto {
    private final Double rating;
    private final String content;

    public Double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public UpdateDto(Double rating, String content) {
        this.rating = rating;
        this.content = content;
    }
}
