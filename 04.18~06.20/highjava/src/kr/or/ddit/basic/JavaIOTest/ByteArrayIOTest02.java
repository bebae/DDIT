package kr.or.ddit.basic.JavaIOTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            while (input.available() > 0) {
                //                input.read(temp);
//                output.write(temp);
                int len = input.read(temp);
                output.write(temp);

                output.write(temp, 0, len);
                System.out.println("반복 안에서 Temp => " + Arrays.toString(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
