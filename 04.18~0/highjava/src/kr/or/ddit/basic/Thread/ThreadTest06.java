package kr.or.ddit.basic.Thread;

import javax.swing.*;

public class ThreadTest06 {
    public static void main(String[] args) {
        DataInput dataInput = new DataInput();
        CountDown countDown = new CountDown();

        dataInput.start();
        countDown.start();

        try {
            dataInput.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("입력값 : " + dataInput.getStr());

        System.out.println("main 종료");
    }
}

// data input Thread
class DataInput extends Thread{
    private String str;
    public static boolean inputCheck = false;       // 스레드에서 공통으로 사용할 변수
    @Override
    public void run() {
        str = JOptionPane.showInputDialog("아무것나 입력해주세요");
        inputCheck = true;
    }
    public String getStr(){
        return str;
    }
}
// count down Thread
class CountDown extends Thread{
    @Override
    public void run() {
        for(int i=10; i>=1; i--){
            if(DataInput.inputCheck){
                return;
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("10초가 지났습니다. 프로그램을 멈춥니다.");
        System.exit(0);
    }
}