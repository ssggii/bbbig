package com.bbbig.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewController {
    private List<Review> list = new ArrayList<>();
    private long id = 1L;

    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run) {
            System.out.println("메뉴를 선택해주세요");
            System.out.println("1.리뷰 글 쓰기");
            System.out.println("2.리뷰 조회");
            System.out.println("3.리뷰 글 수정");
            System.out.println("4.리뷰 글 삭제");
            System.out.println("5.종료");

            int click = sc.nextInt();
            sc.nextLine();

            if (click >= 1 && click <= 5) {
                switch (click) {
                    case 1:
                        System.out.println("리뷰 글을 작성합니다");
                        System.out.println("책 제목을 입력해주세요");
                        String title = sc.nextLine();

                        Long bookId = 111111111111L; //api로 받아와야 함

                        System.out.println("평점을 입력해 주세요 (1~5점)");
                        double rating = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("내용을 입력해 주세요");
                        String content = sc.nextLine();
                        try{
                            Review newReview = new Review(bookId, rating , content);
                            list.add(newReview);
                            newReview.setId(id++);

                            System.out.println(title + "이 등록 되었습니다");
                        }catch (IllegalArgumentException e) {
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
            }else{
                System.out.println("잘못된 입력입니다. 1~5 사이 숫자를 입력해 주세요");
            }
        }
    }
}