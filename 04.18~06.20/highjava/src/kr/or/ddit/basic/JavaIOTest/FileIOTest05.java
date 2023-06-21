package kr.or.ddit.basic.JavaIOTest;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * 한글이 저장된 파일 읽어오기 ==> 한글의 인코딩 방식을 지정해서 읽어오는 예제
 */
public class FileIOTest05 {
    public static void main(String[] args) throws Exception {

        String path = "d:/D_Other/test_ansi.txt";
//        String path = "d:/D_Other/test_utf8.txt";
        FileInputStream fin = new FileInputStream(path);
        
        // 기본 인코딩 방식
//        InputStreamReader isr = new InputStreamReader(fin);
        
        // 지정 인코딩 방식 
        // MS949 : 윈도우 기본 한글 인코딩 방식(=ANSI)
        // UTF-8 : 유니코드 UTF-8 인코딩 방식
        // US-ASCII : 영문 전용 인코딩 방식
        InputStreamReader isr = new InputStreamReader(fin, "ms949");
        
        
        int c;

        while((c=isr.read()) != -1){
            System.out.print((char)c);
        }

        isr.close();
        fin.close();
    }
}
