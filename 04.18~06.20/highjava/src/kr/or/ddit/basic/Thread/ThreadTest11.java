package kr.or.ddit.basic.Thread;

/*
 * Thread 의 stop()메소드를 호출하면 해당 스레드는 즉시 정지한다.
 * 이 때 사용하던 자원을 정리하지 못하고 해당 스레드가 종료되어 다른 스레드의 영향을 줄 수도 있다.
 */
public class ThreadTest11 {
    public static void main(String[] args) {

        InterruptThread it = new InterruptThread();
        it.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // 스레드를 멈추게 하는 연습용 스레드
     private static class StopThread extends Thread {
        private boolean stop;

        public void setStop(boolean stop) {
            this.stop = stop;
        }
        @Override
        public void run() {
            while (!stop) {
                System.out.println("스레드 실행 중...");
            }
            System.out.println("자원 정리");
            System.out.println("스레드 종료...");
        }
    }

    private static class StopThread2 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("스레드 실행 중...");
                    Thread.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("자원 정리");
            System.out.println("스레드 종료...");
        }
    }

    
    // interrupt() 메소드를 이용해서 스레드를 멈추는 연습용 스레드
    private static class InterruptThread extends Thread {
                @Override
        public void run() {
//            do {
//                System.out.println("작업 실행 중...");
//            } while (!Thread.interrupted());
//            System.out.println("자원 정리");
//            System.out.println("스레드 종료");
//            do {
//                System.out.println("작업 실행 중...");
//            } while (!this.isInterrupted());
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
            }
        }
    }
}

