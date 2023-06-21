package kr.or.ddit.basic.Thread;

/*
 * 	1 ~ 20억 까지의 합계를 구하는 프로그램을 단일 스레드로 처리할 때와
 *  멀티 스레드가 처리하는 경과 시간을 비교해보자
 */

public class ThreadTest04 {
    public static void main(String[] args) {
        // 단일 스레드
        SumThread sm = new SumThread(1L, 2_000_000_000L);

        long startTime = System.currentTimeMillis();
        sm.start();
        try {
            sm.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("1 ~ 20,000,000,000 의 합계 : " + sm.getSum());
        System.out.println("단일 스레드 경과 시간  : " + (endTime - startTime));


        // 멀티 스레드
        SumThread[] sumThs = new SumThread[] {
                new SumThread(1L, 50_000_000L),
                new SumThread(50_000_001L, 100_000_000L),
                new SumThread(100_000_001L, 150_000_000L),
                new SumThread(150_000_001L, 200_000_000L),
        };
        startTime = System.currentTimeMillis();
        for (SumThread th : sumThs) {
            th.start();
        }
        for (SumThread th : sumThs) {
            try {
                th.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long sum = 0;
        for (SumThread th : sumThs) {
            sum += th.getSum();
        }
        endTime = System.currentTimeMillis();
        System.out.println("1 ~ 20,000,000,000 의 합계 : " + sum);
        System.out.println("멀티 스레드 경과 시간  : " + (endTime - startTime));
        
    }
}

class SumThread extends Thread {
    private long sum;
    private final long start;
    private final long end;

    public SumThread(long start, long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (long i = start; i <= end; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}
