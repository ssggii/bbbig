package com.bbbig.model;

import java.time.LocalDateTime;

/*
### **[초급] Beginner: 독서기록(ReadingRecord) 객체 구현하기**

- **목표**: ERD를 읽고 `READING_RECORDS` 테이블의 각 컬럼을 Java 필드로 1:1 대응시킵니다. 외부에서 객체를 생성하고 읽을 수 있도록
            생성자와 getter를 작성하며, 생성 시각(`createdAt`)과 수정 시각(`updatedAt`)을 객체 내부에서 자동으로 세팅하는 방법을 익힙니다.
- **요구사항**:
    1. ERD를 보고 `READING_RECORDS`의 컬럼 5개와 타입을 Java 타입으로 매핑합니다. (`BIGINT` → `Long`, `TEXT` → `String`, `TIMESTAMP` → `LocalDateTime`)
    2. **생성자 구현:** 매개변수로 `bookId`와 `status`만 받는 생성자를 사용합니다. `id`는 레포지토리가 부여하므로 생성자에서 받지 않습니다.
    3. `createdAt`과 `updatedAt`은 생성자 내부에서 `LocalDateTime.now()`로 자동 세팅합니다.
    4. **getter 구현:** 필드는 모두 private으로 선언하고, 각 필드에 대한 getter 메서드를 추가합니다.
    5. **setter 구현:** 레포지토리가 `id`를 부여할 수 있도록 `setId(Long id)` 메서드를 작성합니다. 나머지 필드의 setter는 작성하지 않습니다.
 */
public class ReadingRecord {

    /* ---------- 1. 필드 (private) ---------- */
    private Long id;                 // 주입용, 초기값 null
    private final Long bookId;             // ERD의 book_id, 불변성을 표시하기 위해 fianl 붙임
    private String status;           // ERD의 status
    private String sentences;     // ERD의 sentences(날짜형), sentences의 타입을 LocalDate -> String으로 변경
    private final LocalDateTime createdAt; // ERD의 created_at, 불변성을 표시하기 위해 fianl 붙임
    private LocalDateTime updatedAt; // ERD의 updated_at

    /* ---------- 2. 생성자 ---------- */
    public ReadingRecord(Long bookId, String status) {
        this.bookId = bookId;
        this.status = status;
        //get 메서드 법칙에 맞게 수정

        // 생성 시각과 최초 수정 시각을 현재 시간으로 설정
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /* ---------- 3. getter ---------- */
    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getStatus() {
        return status;
    }

    public String getSentences() {
        return sentences;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /* ---------- 4. setter (id 만 허용) ---------- */
    public void setId(Long id) {
        this.id = id;
        // setter 매개변수 추가
    }

}














