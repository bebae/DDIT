package kr.or.ddit.basic.Thread;

public class ThreadTest15 {
    public static void main(String[] args) {
        ShareObject sObj = new ShareObject();

        TestThread th1 = new TestThread(sObj);
        TestThread th2 = new TestThread(sObj);

        th1.start();
        th2.start();
    }
}

// 공통으로 사용할 클래스
class ShareObject {
    private int sum = 0;

    // 동기화 synchronized
//    public synchronized void add() {        // 메소드 자체에 synchronized
    public void add() {
        synchronized(this){
            int n = sum;

            n += 10;

            sum = n;
            System.out.println(Thread.currentThread().getName() + " 의  sum = " + sum);
        }
    }
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

// Test 스레드
class TestThread extends Thread {
    private ShareObject sObj;
    public TestThread(ShareObject sObj) {
        this.sObj = sObj;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            sObj.add();
        }
    }
}