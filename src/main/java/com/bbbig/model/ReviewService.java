package com.bbbig.model;

import com.bbbig.dto.CreateDto;
import com.bbbig.dto.GetReviewDto;
import com.bbbig.dto.UpdateDto;
import com.bbbig.repository.ReviewRepository;

import java.util.List;

public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }


    public GetReviewDto createReview(CreateDto dto) {
        Review review = new Review(dto.bookId(), dto.rating(), dto.content());
        Review saveReview = repository.save(review);
        return GetReviewDto.from(saveReview);
    }

    public GetReviewDto getReview(Long id) {
        Review review = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다"));

        return GetReviewDto.from(review);
    }


    public GetReviewDto update(Long id, UpdateDto updateDto) {
        Review review = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다"));
        review.update(updateDto);
        repository.save(review);
        return GetReviewDto.from(review);
    }

    public void deleteReivew(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("삭제할 ID가 없습니다");
        }
        repository.deleteById(id);


    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return repository.findByBookId(bookId);
    }
}
