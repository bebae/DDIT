package kr.or.ddit.basic.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
    public static void main(String[] args) {
       /*
       문제 ) 5명의 사람 이름을 입력 받아 ArrayList 에 저장한 후에
              이 ArrayList 에 저장된 이름들 중에서 '김'씨 성의 이름을 모두 출력하시오.
              (입력은 Scanner 객체를 이용한다.)
        */
        ArrayList<String> nameList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 이름을 입력 받아 ArrayList에 추가
        for (int i = 0; i < 5; i++) {
            System.out.print("이름을 입력하세요: ");
            String name = scanner.next();
            nameList.add(name);
        }

        // '김'씨 성의 이름 출력
        System.out.print("'김'씨 성의 이름: ");
        for (String name : nameList) {
//            if (name.charAt(0) == '김') {          // 문자열에 0번째 값
//            if (name.startsWith("김")) {           // 문자열에 시작문자
            if (name.indexOf("김") == 0){            // 문자열에 "김"의 위치
                System.out.print(name + " ");
            }
        }
    }
}
