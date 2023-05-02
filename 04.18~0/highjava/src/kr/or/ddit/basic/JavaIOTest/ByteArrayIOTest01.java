package kr.or.ddit.basic.JavaIOTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ByteArrayIOTest01 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data;
        while ((data = input.read()) != -1) {
            output.write(data);       // 출력하기
        }
        outSrc = output.toByteArray(); // 배열로 저장


        try {
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("inSrc => " + Arrays.toString(inSrc));  // 입력한 데이터 출력
        System.out.println("outSrc => " +Arrays.toString(outSrc)); // 출력한 데이터 출력
    }
}
