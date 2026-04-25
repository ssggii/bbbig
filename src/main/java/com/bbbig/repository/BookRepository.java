package com.bbbig.repository;

import com.bbbig.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book); // 책 생성(추가)

    Optional<Book> findById(Long id); // id를 통해 책 1개 조회

    List<Book> findByTitleContaining(String title);// 책 제목으로 전체 조회

    List<Book> findByAuthorContaining(String author); // 저자 이름으로 전체 조회

    List<Book> findAll(); // 전체 책 조회

    void deleteById(Long id); // 책 삭제

    boolean existById(Long id); // 책 존재 여부 확인
}
