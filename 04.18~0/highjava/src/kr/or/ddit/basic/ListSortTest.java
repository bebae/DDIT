package kr.or.ddit.basic;


/*
    정렬과 관련된 interface 는 Comparable 과 Comparator 이렇게 두 가지가 있다.
    Comparable 은 Collection 에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스(내부 정렬 기준)
    Comparator 는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스(외부 정렬 기준)

    Comparable 에서는 compareTo() 메서드 재정의 필요
    Comparator 에서는 compare() 메서드 재정의 필요

    String / Wrapper / Date / File 클래스에는 내부 정렬 기준이 이미 구현되어 있다.
    (이 클래스들의 내부 정렬 기준은 '오름차순'으로 정렬되도록 구현되어 있다.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("일지매");
        list.add("홍길동");
        list.add("성춘향");
        list.add("변학도");
        list.add("이순신");

        System.out.println("정렬 전 : "+list);

        // 정렬은 Collections.sort() 메서드를 이용하여 정렬한다.
        // Collections.sort() 메서드는 기본적으로 오름차순 정렬
        Collections.sort(list);
        System.out.println("정렬 후 : "+list);

    }
}

// 외부 정렬 기준 만들기
// 정렬 방식을 정해주는 Class 를 만든다. (이 클래스를 외부 정렬 기준 클래스라고 한다.)
class Desc implements Comparator<String> {
    /*
     이 compare() 메서드를 이용해서 정렬 기준 설정

     compare() 메서드의 반환값 의미
        0    ==> 두 값이 같다
        양수 ==> 두 값의 순서 바꿈
        음수 ==> 두 값의 순서 바꾸지 않음
     */
    @Override
    public int compare(String o1, String o2) {
        if (o1.compareTo(o2) > 0){
            return -1;
        } else if (o1.compareTo(o2) < 0) {
            return 1;
        }
        return 0;
    }
}










