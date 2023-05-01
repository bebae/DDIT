package kr.or.ddit.basic.Thread;

// 스레드에서 객체를 공통으로 사용하는 예제
/*
 * 원주율을 계산하는 스레드와
 * 계산된 원주율을 출력하는 스레드가 있다.
 *
 * 원주율을 관리하는 객체가 필요하다.
 * 이 원주율을 관리하는 객체를 두 쓰레드에서 공통으로 사용해서 처리하면 된다.
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        // 공통 사용 객체 생성
        ShareData sd = new ShareData();

        // 스레드 객체 생성 후 넘겨주기
        CalcPIThread cpt = new CalcPIThread(sd);
        cpt.setSd(sd);

        PrintPIThread ppt = new PrintPIThread(sd);

        cpt.start();
        ppt.start();

    }

    // 원주율을 관리하는 클래스 (공통으로 사용할 클레스)
    private static class ShareData {
        public double result;
        public volatile boolean isOk = false;

    }

    // 원주율을 출력하는 스레드 ==> 계산이 완료되면 계산된 원주율 출력
    private static class PrintPIThread extends Thread {
        private ShareData sd;

        // 공통으로 사용할 객체의 참조값을 받아 초기화
        public PrintPIThread(ShareData sd) {
            this.sd = sd;
        }

        @Override
        public void run() {
            while(true) {
                if(sd.isOk) {
                    System.out.println("pi = " + sd.result);
                    break;
                } else {
                    Thread.yield();
                }
            }
            System.out.println("\n 계산된 원주율 : "+sd.result);
            System.out.println("      PI       : "+Math.PI);
        }
    }

    private static class CalcPIThread extends Thread {
        private ShareData sd;

        public CalcPIThread(ShareData sd) {
            this.sd = sd;
        }

        public void setSd(ShareData sd) {
            this.sd = sd;
        }

        @Override
        public void run() {
            double sum = 0.0;
            for (int i = 1; i <= 1_000_000_000; i += 2) {
                if((i/2) % 2 == 0){
                    sum += 1.0/i;
                } else {
                    sum -= 1.0/i;
                }
            }
            sd.result = 4 * sum;
            sd.isOk = true; // sd.isOk 값을 true로 변경해준다.
        }
    }
}
