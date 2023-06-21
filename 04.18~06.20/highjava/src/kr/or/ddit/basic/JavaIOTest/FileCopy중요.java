package kr.or.ddit.basic.JavaIOTest;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *  'D:/D_Other/펭귄.jpg 파일을
 *  'D:/D_Other/펭귄_copy.jpg' 파일로 복사하는 프로그램
 */
public class FileCopy중요 {
    public static void main(String[] args) throws Exception {

        File file = new File("D:/D_Other/펭귄.jpg");

        if(!file.exists()){
            System.out.println(file.getName()+" 파일이 없습니다...");
            System.out.println("복사 작업 중지");
            return;
        }

        // 1. 입력용 스트림 객체 생성
        FileInputStream fis = new FileInputStream(file);
        // 2. 입력용 보조 스트림 객체 생성
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 3. 출력용 스트림 객체 생성
        FileOutputStream fos = new FileOutputStream("D:/D_Other/펭귄_copy.jpg");
        // 4. 출력용 보조 스트림 객체 생성
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 5. 데이터를 읽어와 저장할 바이트 배열(buffer) 선언
        byte[] buffer = new byte[1024];
        int bytesRead;  // 6. 읽어온 바이트 수를 저장할 변수

        // 7. 읽기 작업 수행
        while ((bytesRead = bis.read(buffer)) != -1) {
            // 8. 읽어온 데이터를 출력용 스트림에 저장
            bos.write(buffer, 0, bytesRead);
        }
        // 9. 스트림 닫기
        bis.close();
        bos.close();
        fis.close();
        fos.close();

        System.out.println("File Copy 가 완료 되었습니다.");
    }
}
