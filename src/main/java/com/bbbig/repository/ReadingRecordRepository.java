package com.bbbig.repository;

import com.bbbig.model.ReadingRecord;
import java.util.List;
import java.util.Optional;

public interface ReadingRecordRepository {

    ReadingRecord save(ReadingRecord record); // 독서기록 저장

    List<ReadingRecord> findAll(); // 독서기록 전체 조회

    Optional<ReadingRecord> findById(Long id); // 독서기록 상세 조회
    
    void deleteById(Long id); // 독서 기록 삭제

    boolean existsById(Long id); // 독서기록 존재 여부 검사

}
