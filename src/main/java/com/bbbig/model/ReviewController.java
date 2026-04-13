package com.bbbig.model;

import java.util.Scanner;

public class ReviewController {
    

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("메뉴를 선택해주세요");
            System.out.println("1.리뷰 글 쓰기");
            System.out.println("2.리뷰 조회");
            System.out.println("3.리뷰 글 수정");
            System.out.println("4.리뷰 글 삭제");
            System.out.println("5.종료");

            String inputclick = sc.nextLine();
            int click;

            try {
                click = Integer.parseInt(inputclick);
            } catch (NumberFormatException e) {
                System.out.println("메뉴는 숫자만 입력해줍쇼");
                continue;
            }


            if (click >= 1 && click <= 5) {
                switch (click) {
                    case 1:
                        System.out.println("리뷰 글을 작성합니다");
                        System.out.println("책 제목을 입력해주세요");
                        String title = sc.nextLine();

                        if (title == null || title.trim().isEmpty()) {
                            System.out.println("제목은 비울수 없습니다");
                            continue;
                        }


                        if (title.length() > 20) {
                            System.out.println("책 제목은 20자를 초과할 수 없습니다");
                            continue;
                        }


                        Long bookId = 111111111111L; //api로 받아와야 함

                        System.out.println("평점을 입력해 주세요 (1~5점)");
                        String inputrating = sc.nextLine();
                        double rating;

                        try {
                            rating = Double.parseDouble(inputrating);
                        } catch (NumberFormatException e) {
                            System.out.println("평점은 1~5사이만 입력해 주십쇼");
                            break;
                        }
                        System.out.println("내용을 입력해 주세요");
                        String content = sc.nextLine();
                        try {
                            reviewService.createReview(bookId, rating, content);

                            System.out.println(title + "이 등록 되었습니다");
                        } catch (IllegalArgumentException e) {
                            System.out.println("등록 실패" + e.getMessage());
                            System.out.println("메인 메뉴로 돌아갑니다");
                        }

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("시스템을 종료합니다");
                        run = false;
                        break;

                    default:
                        System.out.println("아직 구현되지 않은 기능입니다");
                        break;
                }
            } else {
                System.out.println("잘못된 입력입니다. 1~5 사이 숫자를 입력해 주세요");
            }
        }
    }
}