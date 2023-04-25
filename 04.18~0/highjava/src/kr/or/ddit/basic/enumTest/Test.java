package kr.or.ddit.basic.enumTest;

class MyThread extends Thread {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        System.out.println("Thread " + threadName + " is running");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + threadName + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted");
        }
        System.out.println("Thread " + threadName + " exiting");
    }
}
public class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start();
        t2.start();
    }
}