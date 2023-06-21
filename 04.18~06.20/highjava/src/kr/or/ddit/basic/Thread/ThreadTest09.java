package kr.or.ddit.basic.Thread;

// 스레드의 상태값 출력해 보기
public class ThreadTest09 {
    	public static void main(String[] args) {
        StatePrintThread sp = new StatePrintThread(new TargetThread());

        sp.start();

    }

    private static class StatePrintThread extends Thread {
        private final TargetThread target;      // 스레드 객체(통채로) 들어갈 변수
        public StatePrintThread(TargetThread targetThread) {
            this.target = targetThread;
        }

        @Override
        public void run() {
            while (true) {
                Thread.State state = target.getState();
                System.out.println("TargetThread 상태값 : " + state);

                if (state == Thread.State.NEW) {
                    target.start();
                }

                if (state == Thread.State.TERMINATED) {
                    break;
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  TargetThread 는 실행하는 스레드 예제이다.
     */
    private static class TargetThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            for (long i = 1; i <= 4_000_000_000L; i++) {
                sum += i;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum = 0;
            for (long i = 1; i <= 4_000_000_000L; i++) {
                sum += i;
            }
        }
    }
}
