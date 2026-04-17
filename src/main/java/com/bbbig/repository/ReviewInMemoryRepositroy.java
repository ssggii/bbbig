package com.bbbig.repository;

import com.bbbig.model.Review;

import java.util.*;

public class ReviewInMemoryRepositroy implements ReviewRepository{
    /*
    * 리뷰 데이터를 저장하는 곳 : store
    * HashMap을 사용하며 <키, 값> 형태로 저장
    * <키, 값> = <Long, Review>  ==> <리뷰 ID, 리뷰 객체>
    * */
    Map<Long, Review> store = new HashMap<>();

    private Long sequence = 0L;

    // 리뷰 생성 : id가 null이면 생성
    // 리뷰 수정 : id가 null이 아니면 수정
    @Override
    public Review save(Review review) {
        if (review.getId() == null) {
            review.setId(++sequence);
            store.put(sequence, review);
        } else {
            store.put(review.getId(), review);
        }
        return review;
    }

    // 리뷰 id 기준 1개 조회
    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 리뷰 전체 조회
    @Override
    public List<Review> findAll() {
        return new ArrayList<>(store.values());
    }

    // 리뷰 삭제
    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    // 리뷰 존재 여부 확인
    @Override
    public boolean existsById(Long id) {
        return store.containsKey(id);
    }
}
