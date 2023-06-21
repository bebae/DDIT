package kr.or.ddit.basic.Thread;
/*
 * wait(), notify() 메소드를 이용해서 2개의 스레드가 번갈아 실행되는
 */
public class ThreadTest18 {
    public static void main(String[] args) {
        WorkObject work = new WorkObject();

        ThreadA thA = new ThreadA(work);
        ThreadB thB = new ThreadB(work);

        thA.start();
        thB.start();
    }

    private static class WorkObject {
        public synchronized void methodA() {
            System.out.println("methodA() 실행중...");
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }

        public synchronized void methodB() {
            System.out.println("methodB()  실행중...");
            notify();

            try {
                wait();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }

    private static class ThreadA extends Thread {
        private final WorkObject work;

        public ThreadA(WorkObject work) {
            this.work = work;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work.methodA();
            }
        }
    }
    private static class ThreadB extends Thread {
        private final WorkObject work;

        public ThreadB(WorkObject work) {
            this.work = work;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work.methodB();
            }
        }
    }

}
