package com.bbbig.repository;

import com.bbbig.model.Book;

import java.util.*;

public class BookInMemoryRepository implements BookRepository {
    /*
     * 책 데이터를 저장하는 곳 : store
     * HashMap을 사용하며 <키, 값> 형태로 저장
     * <키, 값> = <Long, Book>  ==> <책 ID, 책 객체>
     * */
    private static Map<Long, Book> store = new HashMap<>();

    private static Long sequence = 0L;

    public BookInMemoryRepository() {
        if (store.isEmpty()) { // 데이터 중복 생성 방지
            initDummyData();
        }
    }

    private void initDummyData() {
        save(new Book(1L, "자바의 정석", "남궁성", "도우출판"));
        save(new Book(2L, "이것이 자바다", "신용권", "한빛미디어"));
        save(new Book(3L, "스프링 부트 실전", "김영한", "인프런"));
        save(new Book(4L, "Clean Code", "Robert C. Martin", "Pearson"));
        save(new Book(5L, "Effective Java", "Joshua Bloch", "Addison-Wesley"));
        save(new Book(6L, "모던 자바 인 액션", "라울-게이브리얼 우르마", "한빛미디어"));
        save(new Book(7L, "객체지향의 사실과 오해", "조영호", "위키북스"));
        save(new Book(8L, "Refactoring", "Martin Fowler", "Addison-Wesley"));
        save(new Book(9L, "데이터베이스 개론", "박우창", "한빛아카데미"));
        save(new Book(10L, "토비의 스프링", "이일민", "에이콘"));
    }

    /*
     * 책 생성(수정)
     * @return 생성 또는 수정된 Book
     * */
    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            book.assignId(++sequence);
            store.put(book.getId(), book);
        } else {
            store.put(book.getId(), book);
        }
        return book;
    }

    /*
     * 책 id로 책 1개 조회
     * @return 조회 결과(Book), 조회 결과가 없으면 비어있는 Optional
     * */
    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /*
     * 책 제목에 특정 문자열이 포함된 책 목록 조회
     * @return 검색된 책 목록 (일치하는 결과가 없으면 빈 리스트 반환)
     * */
    @Override
    public List<Book> findByTitleContaining(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : store.values()) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }

    /*
     * 책 저자에 특정 문자열이 포함된 책 목록 조회
     * @return 검색된 책 목록 (일치하는 결과가 없으면 빈 리스트 반환)
     * */
    @Override
    public List<Book> findByAuthorContaining(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : store.values()) {
            if (book.getAuthor().contains(author)) {
                result.add(book);
            }
        }
        return List.of();
    }

    /*
     * 전체 책 목록 조회
     * @return 검색된 책 목록 (일치하는 결과가 없으면 빈 리스트 반환)
     * */
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(store.values());
    }

    /*
     * 책 id로 삭제
     * */
    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    /*
     * 책 id로 해당 책이 존재하는지 여부 확인
     * @return 존재하면 true, 존재하지 않으면 false
     * */
    @Override
    public boolean existById(Long id) {
        return store.containsKey(id);
    }
}
