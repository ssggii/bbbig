package com.bbbig.handling;

import java.util.Scanner;

public class InputHandling {


    private static final Scanner sc = new Scanner(System.in);

    //Long 예외 처리
    public static Long readLong(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Long.parseLong(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다");
            }
        }
    }

    //String 예외 처리
    public static String readString(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine().trim();
            if (input.isBlank()) {
                System.out.println("비워져 있으면 안됩니다");
                continue;
            }
            return input.trim();
        }
    }


    //double 예외 처리
    public static Double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다");
            }
        }
    }
}
