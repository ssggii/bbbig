package com.bbbig.model;


import com.bbbig.repository.ReadingRecordRepository;


public class ReadingRecordService {

    //필드 변수선언
    private final ReadingRecordRepository readingRecordRepository;


    //생성자
    public ReadingRecordService(ReadingRecordRepository repository) {
        this.readingRecordRepository = repository;
    }

    //유효성 검증
    public ReadingRecord createRecord(Long bookId, Status status, String sentences) {

        //bookId : bookId에 등록된 값인가
        if (readingRecordRepository.existsById(bookId) == false) {
            throw new IllegalArgumentException("등록되지 않은 도서ID 입니다.");
        }

        //status
        //Enum 클래스로 READING, BEFORE, COMPLETE 값만 저장됩니다.

        //sentences
        //유효성 기준 검토 중 입니다.
        if (sentences != null) {
            if (sentences.isBlank())
                throw new IllegalArgumentException("문장을 입력해 주세요.");
            sentences = sentences.trim();
            if (sentences.length() > 50) {
                throw new IllegalArgumentException("문장은 한 문장(50자)만 받겠습니다.");
            }

        //검증 완료 newRecord에 저장
        ReadingRecord newRecord = new ReadingRecord(bookId, status, sentences);

        //레포지토리 저장
        newRecord = readingRecordRepository.save(newRecord);

        return newRecord;

    }


}