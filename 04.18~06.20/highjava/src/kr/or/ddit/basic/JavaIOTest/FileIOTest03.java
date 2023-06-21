package kr.or.ddit.basic.JavaIOTest;

import java.io.FileReader;

public class FileIOTest03 {
    public static void main(String[] args) throws Exception {
        // 파일 출력용 파일 객체 생성 ==> 문자기반 스트림 (한글 가능)
        FileReader fr = new FileReader("d:/D_Other/test.txt");

        int c;

        while ((c = fr.read()) != -1) {
            System.out.print((char)c);
        }

        fr.close();
    }
}
