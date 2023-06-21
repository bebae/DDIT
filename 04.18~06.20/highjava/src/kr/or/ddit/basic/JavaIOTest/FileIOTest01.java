package kr.or.ddit.basic.JavaIOTest;

import java.io.File;
import java.io.FileInputStream;

public class FileIOTest01 {
    public static void main(String[] args) throws Exception {
        // 사용할 스트림 객체 생성 ==> 파일을 읽어 바이트기반 스트림 객체 생성(한글 안됌)

        // 방법1 : 문자열로 지정
        FileInputStream  fis = new FileInputStream("d:/D_Other/test.txt");

        // 방법2 : File 객체로 저장
        File file = new File("d:/D_Other/test.txt");
        FileInputStream fis2 = new FileInputStream(file);


        int c;  // 가져온 데이터 저장 변수
        while ((c = fis.read()) != -1) {
            System.out.print((char) c);
        }
        fis.close();
        fis2.close();

    }
}
