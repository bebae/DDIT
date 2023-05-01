package kr.or.ddit.basic.Thread;

// yield() 예제
public class ThreadTest10 {
    public static void main(String[] args) {
        ThreadTest10_Yield th1 = new ThreadTest10_Yield("1번 스레드");
        ThreadTest10_Yield th2 = new ThreadTest10_Yield("2번 스레드");
        th1.start();
        th2.start();
        try {
            Thread.sleep(5);
            System.out.println("---------------- 1번 휴식  -----------------");
            th1.work = false;
            Thread.sleep(5);
            System.out.println("---------------- 2번 휴식  -----------------");
            th1.work = true;
            Thread.sleep(10);
            System.out.println("---------------- 3번 휴식  -----------------");
            th1.stop = true;
            th2.stop = true;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "  ");
            if (i == 5) {
                Thread.yield();
            }
        }
    }
    private static class ThreadTest10_Yield extends Thread {
        private boolean stop = false;
        private boolean work = true;
        public boolean isWork() {
            return work;
        }
        public void setWork(boolean work) {
            this.work = work;
        }
        public boolean isStop() {
            return stop;
        }
        public void setStop(boolean stop) {
            this.stop = stop;
        }
        
        public ThreadTest10_Yield(String name) {
            super(name);
        }
        @Override
        public void run() {
            while (!stop) {
                if (work) {
                    System.out.println(getName() + " 작업 중... ");
                } else {
                    Thread.yield();
                }
            }
            System.out.println(getName() + " 양보 중...");
        }
    }
}

