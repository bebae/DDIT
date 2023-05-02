package kr.or.ddit.basic.JavaIOTest;

import java.io.FileOutputStream;

/**
 *  파일에 데이터를 출력하는 예제 - 바이트 기반 스트림 사용
 */
public class FileIOTest02 {
    public static void main(String[] args) throws Exception {
        // 파일 출력용 파일 객체 생성
        FileOutputStream fout = new FileOutputStream("d:/D_Other/out.txt");

        for (char ch='A'; ch<='Z'; ch++) {
            fout.write(ch);     // ch를 파일로 출력한다.
        }
        System.out.println("출력 작업 완료");

        fout.close();
    }
}
