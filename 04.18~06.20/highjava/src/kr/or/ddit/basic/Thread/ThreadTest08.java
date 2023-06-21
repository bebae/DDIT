package kr.or.ddit.basic.Thread;

// 데몬 스레드 연습 ==> 자동 저장하는 스레드
public class ThreadTest08 {
    public static void main(String[] args) {
        AutoSaveThread autoSave = new AutoSaveThread();
        System.out.println("Daemon Thread 여부 : "+autoSave.isDaemon());
        autoSave.setDaemon(true);       // start() 전에 실행해야 된다.
        System.out.println("Daemon Thread 여부 : "+autoSave.isDaemon());
        autoSave.start();

        try {
            for(int i=1; i<=20; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 메소드 종료");
    }
    static class AutoSaveThread extends Thread{
        public void save() {
            System.out.println("save...");
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 3초 마다 save() 실행
                save();
            }
        }
    }
}

