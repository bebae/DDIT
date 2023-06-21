package kr.or.ddit.basic.Thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 *  Collection 객체들의 내부 동기화 처리 확인
 */
public class ThreadTest17 {
    private static final Vector<Integer> vec = new Vector<>();

    // 동기화 처리가 안 된 ArrayList
//    private static final List<Integer> list1 = new ArrayList<>();

// 동기화 처리가 된 ArrayList
    private static final List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 100000; i++) {
                vec.add(i);
                list2.add(i);
            }
        };

        Thread[] ths = new Thread[] {
                new Thread(r),new Thread(r),new Thread(r),new Thread(r),new Thread(r)
        };

        for(Thread th : ths) {
            th.start();
        }
        for (Thread t: ths) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("vec size : " + vec.size());
//        System.out.println("list1 size : " + list1.size());
        System.out.println("list2 size : " + list2.size());
    }
}
