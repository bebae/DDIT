package kr.or.ddit.basic.Thread;

public class ThreadTest01 {
    public static void main(String[] args) {
        // 싱글 스레드 프로그램 작성

        for (int i = 1; i <= 200; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 1; i <= 200; i++) {
            System.out.print("$");
        }
        System.out.println();


    }
}
