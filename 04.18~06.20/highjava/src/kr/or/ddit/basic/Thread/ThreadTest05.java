package kr.or.ddit.basic.Thread;

import javax.swing.*;

public class ThreadTest05 {
    public static void main(String[] args) {

        String str = JOptionPane.showInputDialog("아무거나 입력하세요 ");
        System.out.println("입력한 값 : "+str);

        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("for 이  ㄱㄱ");

    }
}