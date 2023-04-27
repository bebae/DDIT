package kr.or.ddit.basic.Thread;

public class ThreadTest02 {
    public static void main(String[] args) {
        // 멀티 스레드 프로그램 작성하기
        // 1. 상속 : Thread 상속받아 run() 정의 후 start()로 호출해 실행
        // 2. 인터페이스 : Runnable 인터페이스를 구현하여 run()를 오버라이딩 하고
        //                 객체를 생성할 때 Thread 타입으로 생성하고 MyThread2 를 넘겨주고 start()로 실행
        // 3. 인터페이스 익명 구현체 :

        MyThread1 th1 = new MyThread1();
        MyThread2 r2 = new MyThread2();
        Thread th2 = new Thread(r2);
        Runnable r3 = () -> {
            for(int i=1; i<=200; i++){
                System.out.print("#");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread th3 = new Thread(r3);
        th1.start();
        th2.start();
        th3.start();
        System.out.println("main 메소드 종료");
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=200; i++){
            System.out.print("*");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=200; i++){
            System.out.print("$");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}