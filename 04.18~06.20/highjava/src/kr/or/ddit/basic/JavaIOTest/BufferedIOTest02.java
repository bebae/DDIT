package kr.or.ddit.basic.JavaIOTest;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedIOTest02 {
    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("./src/kr/or/ddit/basic/JavaIOTest/FileTest01.java");
        BufferedReader br = new BufferedReader(fr);

        String temp="";

        // 문자 기반 입력용 Buffered 스트림에는 한 줄 단위로 읽어오는 readLine()메소드
        for (int i = 1; (temp= br.readLine())!=null;i++){
            System.out.printf("%4d : %s\n", i,temp);
        }

        br.close();

    }
}
