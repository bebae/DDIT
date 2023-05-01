package kr.or.ddit.basic.Thread;

import sun.awt.DisplayChangedListener;

import java.util.Random;

/*
 * Thread 3개가 각각 알파벳을 A~Z 까지 출력하는데
 * 출력이 끝낸 순서대로 결과를 나타내는 프로그램을 작성하시오
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        AlphabetThread[] thArr = new AlphabetThread[] {
                new AlphabetThread("1번"),
                new AlphabetThread("2번"),
                new AlphabetThread("3번")
        };

        for(AlphabetThread th : thArr) {
            th.start();
        }

        for(AlphabetThread th : thArr) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------------------");
        System.out.println("setOrder => " + AlphabetThread.setOrder);
        System.out.println("-----------------------");
    }

    private static class AlphabetThread extends Thread {
        public static String setOrder = "";
        private final String name;

        public AlphabetThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.println(name + "의 출력문자 : " +ch);
                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name+"의 출력 끝...");
            AlphabetThread.setOrder += name+" ";
        }
    }
}
