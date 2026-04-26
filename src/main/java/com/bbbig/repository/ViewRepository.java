package com.bbbig.repository;

import com.bbbig.model.Book;

import java.util.List;

public interface ViewRepository {

    String inputReviewContent();

    Double inputRating();

    Long inputChoose();

    Long inputBookId();

    Long inputReviewId();

    void printBookList(List<Book> books);

    void errOutPut(String message);

    void outPut(String message);
}
