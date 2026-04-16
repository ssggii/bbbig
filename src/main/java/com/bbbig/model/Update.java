package com.bbbig.model;

public class Update {
    private Double rating;
    private String content;

    public Double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public Update(Double rating, String content) {
        this.rating = rating;
        this.content = content;
    }
}
