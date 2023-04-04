package chapter11;

import java.io.IOException;

public class KeyboardToStringExample {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[100];

        System.out.print("입력: ");
        // 배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴
        int readByteNo = System.in.read(bytes);

        // 입력 후 엔터를 입력하기에 캐리지린터(\r)+라인피드(\n)의 코드값을 제외하고 출력하기 위함
        String str = new String(bytes, 0, readByteNo-2);
        System.out.println(str);

    }
}
