package com.bbbig.model;

public class Book {
    /*1.필드 추가*/
    private Long id;
    private String title;
    private String author;
    private String publisher;



    /*2. 생성자 추가*/

    public Book(Long id, String title, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public void assignId(Long id) {
        this.id = id;
    }
    /*3.Getter 생성   */

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}

