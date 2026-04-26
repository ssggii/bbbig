package com.bbbig.repository;

import com.bbbig.handling.InputHandling;
import com.bbbig.model.Book;

import java.util.List;
import java.util.Scanner;

public class ReviewViewMemoryRepository implements ViewRepository {

    Scanner sc = new Scanner(System.in);
    InputHandling inputHandling = new InputHandling();

    @Override
    public String inputReviewContent() {
        return inputHandling.readString("리뷰 내용을 입력해주세요");
    }

    @Override
    public Double inputRating() {
        return inputHandling.readDouble("평점을 입력해 주세요 : ");
    }

    @Override
    public Long inputChoose() {
        return inputHandling.readLong("숫자를 입력해 주세요 : ");
    }

    @Override
    public Long inputBookId() {
        return inputHandling.readLong("책 번호를 입력해주세요");
    }

    @Override
    public Long inputReviewId() {
        return inputHandling.readLong("리뷰 번호를 입력해주세요");
    }

    @Override
    public void printBookList(List<Book> books) {
        for (Book b : books) {
            System.out.println(b.getId() + " . " + b.getTitle());
        }
    }

    @Override
    public void errOutPut(String message) {
        System.err.println(message);
    }

    @Override
    public void outPut(String message) {
        System.out.println(message);
    }

}

