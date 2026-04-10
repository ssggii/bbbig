package com.bbbig.model;

import java.time.LocalDate;
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

    //`READING_RECORDS`의 컬럼 5개와 타입을 Java 타입으로 매핑
    private long id;
    private long book_id;
    private String status;
    private LocalDate sentences;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    //생성자 구현, 매개변수로 `bookId`와 `status`만 받는 생성자를 사용
    ReadingRecord readingRecord = new ReadingRecord(long bookId, String status);

    //`createdAt`과 `updatedAt`은 생성자 내부에서 `LocalDateTime.now()`로 자동 세팅


    //각 필드에 대한 getter 메서드 추가
    public long getBook_id() {
        return book_id;
    }
    public String getStatus() {
        return status;
    }
    public  LocalDate getSentences() {
        return sentences;
    }
    public  LocalDateTime getCreated_at() {
        return created_at;
    }
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

//    레포지토리가 `id`를 부여할 수 있도록 `setId(Long id)` 메서드를 작성합니다.
    public long setId(){
        this.id = id;
    }





}














