package scheduler;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer01 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        // 1초 후에 실행되며 2초마다 반복 실행
        timer.schedule(new MyTask(), 1000, 2000);
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Timer task started at:" + new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Timer task finished at:" + new Date());
        }
    }
}