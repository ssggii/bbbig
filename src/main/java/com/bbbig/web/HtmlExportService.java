package com.bbbig.web;


import com.bbbig.model.Book;
import com.bbbig.model.Review;

import java.util.List;

public class HtmlExportService {


    public void generateBookDetail(Book book, List<Review> reviews) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset='UTF-8'><title>").append(book.getTitle()).append("</title></head>");
        sb.append("<body>");
        sb.append("<h1>").append(book.getTitle()).append(" - ").append(book.getAuthor()).append("</h1>");

        sb.append("<h3>리뷰 목록</h3><ul>");
        for (Review r : reviews) {
            sb.append("<li>").append(r.getContent()).append("</li>");
        }
        sb.append("</ul>");

        sb.append("<a href='index.html'>목록으로 돌아가기</a>");
        sb.append("</body></html>");

        String fileName = "book_" + book.getId() + ".html";
        FileUtil.saveHtml(fileName, sb.toString());
    }

    public void generateMainPage(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><meta charset='UTF-8'><title>도서 목록</title></head><body>");
        sb.append("<h1>도서 목록</h1><ul>");

        for (Book book : books) {
            String link = "book_" + book.getId() + ".html";
            sb.append("<li><a href='").append(link).append("'>")
                    .append(book.getTitle()).append("</a></li>");
        }

        sb.append("</ul></body></html>");
        FileUtil.saveHtml("index.html", sb.toString());
    }
}



