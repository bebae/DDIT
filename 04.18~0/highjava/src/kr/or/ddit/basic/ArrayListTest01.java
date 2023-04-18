package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
    public static void main(String[] args) {
        // ArrayList 의 기본적인 사용법은 Vector 와 같다.
        ArrayList list1 = new ArrayList();

        // add() 메소드를 이용해서 데이터를 추가한다.
        list1.add("aaa");
        list1.add("bbb");
        list1.add(123);
        list1.add('k');
        list1.add(false);
        list1.add(123.45);

        System.out.println("list1 => "+list1);
        System.out.println("size => "+list1.size());

        // 데이터 변경
        String sTemp = (String)list1.set(1,"yyy");
        System.out.println("list1 index 3을 yyy로 변경 => "+list1);
        System.out.println("반환값 : "+sTemp);


        System.out.println("---------------------------------------");

        // contains(비교 데이터) ==> 리스트에 저장된 데이터 중에서 '비교데이터'가 있으면 true, 없으면 false 반환
        System.out.println("yyy값 존재 여부 : "+list1.contains("yyy"));
        System.out.println("zzz값 존재 여부 : "+list1.contains("zzz"));

        /*
        indexOf(비교데이터), lastIndexOf(비교데이터)
            ==> '비교데이터'가 있으면 그 값이 저장된 index 값 반환 없으면 -1 반환
            ==> indexOf 앞에서 뒤로 검색, lastIndexOf는 뒤에서 앞쪽으로 검색
            ==> 검색한 데이터와 일치한 가장 첫번째 데이터의 index 값을 반환
         */

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        list2.add("D");
        list2.add("E");
        System.out.println("list2 => "+list2);
        System.out.println("list2의 크기 => "+list2.size());
        System.out.println("D의 index 값 : "+list2.indexOf("D"));
        System.out.println("Z의 index 값 : "+list2.indexOf("Z"));
        System.out.println("D의 index 값 : "+list2.lastIndexOf("D"));
        System.out.println("-------------------------------------");

        // toArray() ==> 리스트 안의 데이터들을 배열로 변환해서 반환한다.
        //           ==> 기본적으로 Object 형 배열로 변환한다.
        // toArray(new String[0]) ==> 제너릭 타입의 배열로 변환해서 반환함

        Object[] strArr = list2.toArray();
        // String[] strArr = (String[])list2.toArray();     // 이건 안 됨
        System.out.println("배열의 길이 : "+strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(i+" ==> "+strArr[i]);
        }
        System.out.println("-------------------------------------");

        String[] strArr2 = list2.toArray(new String[list2.size()-1]);
        for (String str : strArr2) {
            System.out.println(str);
        }


    }
}


















