package com.bbbig;

import com.bbbig.controller.ReviewController;
import com.bbbig.model.ReviewService;
import com.bbbig.repository.*;
import com.bbbig.web.HtmlExportService;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookInMemoryRepository();
        ReviewRepository reviewRepo = new ReviewInMemoryRepositroy();
        ViewRepository viewRepo = new ReviewViewMemoryRepository();
        HtmlExportService htmlExportService = new HtmlExportService();


        ReviewService reviewService = new ReviewService(reviewRepo);

        ReviewController controller = new ReviewController(bookRepo, viewRepo, reviewService, htmlExportService);

        controller.start();

    }
}
