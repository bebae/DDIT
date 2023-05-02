package kr.or.ddit.basic.JavaIOTest;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileIOTest04 {
    public static void main(String[] args) throws Exception {
        // 파일 출력용 문자 기반 스트림을 이용해서 파일에 출력하기
        // 사용자가 입력한 내용을 그대로 파일로 저장하는 예제

        // System.in  : 콘솔(표준입출력장치)의 입력 장치의 바이트기반의 입력용 스트림 객체
        // System.out : 콘솔(표준입출력장치)의 출력 장치의 바이트기반의 출력용 스트림 객체

        // 바이트기반 스트림 -> 문자기반 스트림을 실행하는 보조 스트림
        // ==> InputStreamReader(입력용), OutputStreamWriter(출력용)
        InputStreamReader isr = new InputStreamReader(System.in);       // 키보드 입력용 스트림

        FileWriter fw = new FileWriter("d:/D_Other/testChar.txt");

        System.out.println("아무 내용이나 입력하세요 (입력의 끝은 Ctrl+D 입니다.)");

        int c;
        while ((c = isr.read()) != -1) {
            fw.write(c);
        }

        isr.close();
        fw.close();
    }
}
