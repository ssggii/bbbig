package com.bbbig.repository;

import com.bbbig.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Review save(Review review); // 리뷰 생성(수정)

    Optional<Review> findById(Long id); // id를 통해 리뷰 조회

    List<Review> findAll(); // 전체 리뷰 조회

    void deleteById(Long id); // id를 통해 리뷰 삭제

    boolean existsById(Long id); // 해당 id를 가진 리뷰가 있는지 조회

    List<Review> findByBookId(Long bookId); // 특정 책 번호로 리뷰 목록 조회

}
