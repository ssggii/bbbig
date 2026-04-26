package com.bbbig.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileUtil {
    public static void saveHtml(String fileName, String content) {
        Path path = Path.of(fileName);
        try {
            Files.writeString(path, content);
            System.out.println(fileName + " 파일이 성공적으로 생성되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
