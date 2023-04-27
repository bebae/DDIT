package kr.or.ddit.basic.Thread;

public class ThreadTest03 {
    public static void main(String[] args) {
        // 스레드가 수행되는 시간 체크 하기
        Thread th1 = new Thread(new MyRunnable());
        // 1970년 1월 1일 0시 0분 0초 부터 현재시간까지 경과한 시간을 밀리세컨드(1/1000)로 반환
        long startTime = System.currentTimeMillis();
        System.out.println("startTime : " + startTime);
        th1.start();        // run을 실행할 환경을 만들어줌
        try {
            th1.join();     // th1 스레드가 종료될 때까지 기다린다.
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("endTime : " + endTime);
        System.out.println("th1 경과 시간 : " + (endTime - startTime));

    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        long sum = 0;
        for (long i = 1L; i <= 1000000000L; i++) {
            sum += i;
        }
        System.out.println("합계 : " + sum);
    }
}
