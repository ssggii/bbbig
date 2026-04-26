package com.bbbig.dto;


public record CreateDto(Long bookId, Double rating, String content) {
    public CreateDto {
        if (bookId == null) {
            throw new IllegalArgumentException("아이디를 입력해 주세요");
        }
        if (content != null) {
            content = content.trim();
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("리뷰 내용은 비우면 안됩니다");
        }
        if (content.length() > 50) {
            throw new IllegalArgumentException("리뷰는 50자를 초과할 수 없습니다");
        }

        if (rating != null) {
            if (rating > 5.0 || rating < 1.0) {
                throw new IllegalArgumentException("1~5점 사이를 입력해주세요");
            }
        }
    }
}
