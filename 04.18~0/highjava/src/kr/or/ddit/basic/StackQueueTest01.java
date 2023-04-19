package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest01 {
    public static void main(String[] args) {
        /*
        Stack ==> 후입선출(LIFO) 자료구조 Last In First Out

        Stack 의 명령
            1. 자료 입력 : push(입력값)
            2. 자료 출력 : pop()  ==> 자료를 꺼내온 후 자료는 Stack 에서 삭제
                           peek() ==> 삭제없이 자료를 꺼내옴
         */
        Stack<String> stack = new Stack<String>();

        stack.push("홍길동");
        stack.push("일지매");
        stack.push("변학도");
        stack.push("강감찬");

        System.out.println("현재 Stack 값 : "+stack);

        String data = stack.pop();
        System.out.println("꺼내온 값 : "+data);
        System.out.println("꺼내온 값 : "+stack.pop());
        System.out.println("현재 Stack 값 : "+stack);
        System.out.println();

        stack.push("성춘향");
        System.out.println("추가 후 Stack 값 : "+stack);
        System.out.println();

        System.out.println("꺼내온 값 : "+stack.pop());
        System.out.println("현재 Stack 값 : "+stack);
        System.out.println();

        System.out.println("삭제없이 꺼내온 값 : "+stack.peek());
        System.out.println("현재 Stack 값 : "+stack);
        System.out.println("---------------------------------------\n");

        /*
        Queue ==> 선입선출 FIFO 자료구조
        Queue 의 명령
            1. 자료 입력 : offer(입력값)
            2. 자료 출력 : poll() ==> 자료를 꺼내오고 자료를 Queue 에서 삭제한다.
                           peek() ==> 삭제없이 자료를 꺼내온다.
         */

        Queue<String> queue = new LinkedList<>();

        queue.offer("홍길동");
        queue.offer("일지매");
        queue.offer("변학도");
        queue.offer("강감찬");

        System.out.println("현재 queue 값 : "+queue);

        String temp = queue.poll();
        System.out.println("꺼내온 값 : "+temp);
        System.out.println("꺼내온 값 : "+queue.poll());
        System.out.println("현재 queue 값 : "+queue);
        System.out.println();


        queue.offer("성춘향");
        System.out.println("현재 queue 값 : "+queue);
        System.out.println();

        System.out.println("꺼내온 값 : "+queue.poll());
        System.out.println("현재 queue 값 : "+queue);
        System.out.println();

        System.out.println("삭제없이 꺼내오기 : "+queue.peek());
        System.out.println("현재 queue 값 : "+queue);

    }

}






























