package com.bbbig.model;

public class UpdateDto {
    private final Double rating;
    private final String content;


    public UpdateDto(Double rating, String content) {
        if (rating == null && content == null) {
            throw new IllegalArgumentException("수정할 값을 최소 하나는 입력해주세요");
        }
        if (rating != null) {
            if (rating > 5.0 || rating < 1.0) {
                throw new IllegalArgumentException("1~5점 사이를 입력해주세요");
            }
        }
        if (content != null) {
            if (content.isBlank())
                throw new IllegalArgumentException("리뷰 내용은 비우면 안됩니다");
            content = content.trim();
            if (content.length() > 50) {
                throw new IllegalArgumentException("리뷰는 50자를 초과할 수 없습니다");
            }
        }
        this.rating = rating;
        this.content = content;
    }

    public Double getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }
}
