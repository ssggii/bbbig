package com.bbbig.controller;

import com.bbbig.dto.CreateDto;
import com.bbbig.dto.GetReviewDto;
import com.bbbig.dto.UpdateDto;
import com.bbbig.model.Book;
import com.bbbig.model.Review;
import com.bbbig.model.ReviewService;
import com.bbbig.repository.BookRepository;
import com.bbbig.repository.ViewRepository;
import com.bbbig.web.HtmlExportService;

import java.util.List;

public class ReviewController {

    private final BookRepository bookRepository;
    private final ViewRepository viewRepository;
    private final ReviewService reviewService;
    private final HtmlExportService htmlExportService;

    public ReviewController(BookRepository bookRepository, ViewRepository ViewRepository, ReviewService reviewService, HtmlExportService htmlExportService) {
        this.bookRepository = bookRepository;
        this.viewRepository = ViewRepository;
        this.reviewService = reviewService;
        this.htmlExportService = htmlExportService;
    }


    //시작
    public void start() {
        while (true) {
            viewRepository.outPut("1. 저장 | 2. 조회 | 3. 수정 | 4. 삭제 | 5. html 저장 | 6. 종료");
            int choose = Math.toIntExact(viewRepository.inputChoose());
            switch (choose) {
                case 1:
                    // 저장
                    viewRepository.printBookList(bookRepository.findAll());
                    Long bookId = viewRepository.inputBookId();
                    if (!bookRepository.existById(bookId)) {
                        viewRepository.errOutPut("그런 책은 없다!");
                        break;
                    }
                    String content = viewRepository.inputReviewContent();
                    Double rating = viewRepository.inputRating();
                    try {
                        CreateDto createdto = new CreateDto(bookId, rating, content);
                        reviewService.createReview(createdto);
                        viewRepository.outPut("저장이 완료되었습니다");
                    } catch (IllegalArgumentException e) {
                        viewRepository.errOutPut("저장 실패 " + e.getMessage());
                    }
                    break;
                case 2:
                    // 조회
                    Long findId = viewRepository.inputReviewId();
                    try {
                        GetReviewDto getReviewDto = reviewService.getReview(findId);
                        Book book = bookRepository.findById(getReviewDto.bookId())
                                .orElseThrow(() -> new IllegalArgumentException("연결된 책 데이터가 소실되었습니다."));
                        viewRepository.outPut(book.getTitle() + "에 대한 리뷰");
                        viewRepository.outPut("평점 : " + getReviewDto.rating() + " | 내용 : " + getReviewDto.content());
                    } catch (IllegalArgumentException e) {
                        viewRepository.errOutPut(e.getMessage());
                    }
                    break;
                case 3:
                    // 수정
                    Long updateReviewId = viewRepository.inputReviewId();
                    String updateContent = viewRepository.inputReviewContent();
                    Double updateRating = viewRepository.inputRating();
                    UpdateDto updateDto = new UpdateDto(updateRating, updateContent);
                    try {
                        reviewService.update(updateReviewId, updateDto);
                        viewRepository.outPut("수정완료");
                    } catch (IllegalArgumentException e) {
                        viewRepository.errOutPut(e.getMessage());
                    }
                    break;
                case 4:
                    // 삭제
                    Long deleteId = viewRepository.inputReviewId();
                    try {
                        reviewService.deleteReivew(deleteId);
                        viewRepository.outPut("삭제 완료");
                    } catch (IllegalArgumentException e) {
                        viewRepository.errOutPut(e.getMessage());
                    }
                    break;
                case 5:
                    // HTML 추출
                    viewRepository.outPut("Html start");
                    List<Book> allBooks = bookRepository.findAll();
                    htmlExportService.generateMainPage(allBooks);
                    for (Book book : allBooks) {
                        List<Review> bookReviews = reviewService.getReviewsByBookId(book.getId());
                        htmlExportService.generateBookDetail(book, bookReviews);
                    }
                    viewRepository.outPut("HTML End");
                    break;
                case 6:
                    viewRepository.outPut("프로그램을 종료합니다.");
                    return;
                default:
                    viewRepository.errOutPut("잘못된 메뉴 번호입니다.");
                    break;
            }
        }
    }
}
