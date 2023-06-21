package kr.or.ddit.basic.Thread;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 컴퓨터와 가위바위보를 하는 프로그램
 * 컴퓨터의 난수로 가위바위보를 하며
 * 사용자의 입력은 showInputDialog() 메소드를 이용해서 입력 받는다.
 * 입력시간 제한은 5초 없으면 패배 처리
 */
public class ThreadTest07 {

    static boolean inputCheck = false;
    public static void main(String[] args) {
        Random random = new Random();
        String[] str = {"가위","바위","보"};

        // 입력 시간 체크하는 스레드 시작
        CountDownThread countDown = new CountDownThread();
        countDown.start();

        // 사용자가 입력한 값
        String user = "";
        inputCheck = true;
        // 컴퓨터가 뽑은 값
        String com = str[random.nextInt(3)];
        // 게임 결과
        String result = "";

        while (true) {
            user = JOptionPane.showInputDialog("가위 바위 보를 입력해주세요");

            if (!user.equals("가위") && !user.equals("바위") && !user.equals("보")) {
                System.out.println("-- 결  과 --");
                System.out.println("입력값 오류 입니다.");
                System.out.println("가위 바위 보 중에서 입력해 주세요");
                // 입력 받기 전 inputCheck 값을 false 로 설정합니다.
                inputCheck = false;
                // CountDownThread 를 중지하고 다시 실행하도록 처리합니다.
                countDown = new CountDownThread();
                CountDownThread.stop = true;
                countDown.start();

            } else {
                break;
            }
        }

        if(user.equals(com)) {
            result = "비겼습니다.";
        } else if(user.equals("가위") && com.equals("바위")
                || user.equals("바위") && com.equals("보")
                || user.equals("보") && com.equals("가위")) {
            result = "당신이 이겼습니다.";
        } else {
            result = "당신이 졌습니다.";
        }

        System.out.println("-- 결  과 --");
        System.out.println("컴퓨터 : " + com);
        System.out.println("사용자 : " + user);
        System.out.println("결  과 : "+ result);
    }
    /**
     * 5초간 입력이 없으면 게임 패배 처리하는 스레드
     */
    static class CountDownThread extends Thread{
        static boolean stop = false;
        @Override
        public void run() {
            for(int i=5; i>=1; i--){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(stop){                           // 입력값 오류일 때 조건
                    return;
                }
                if(!ThreadTest07.inputCheck) {     // 첫 번째 입력 전에만 카운트 다운
                    return;
                }
//            if(stop){                           // 입력값 오류일 때 조건
//                return;
//            }
            }
            System.out.println("-- 결  과 --");
            System.out.println("5초가 지났습니다.");
            System.out.println("시간 초과로 패배!");
            System.exit(0);
        }
    }
}
