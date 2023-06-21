package kr.or.ddit.basic.collection;

import My.randomType;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    public static void main(String[] args) throws IOException {

    /*
    - List 와 Set 의 차이
    1. List
        - 데이터의 순서(index)가 있다.
        - 중복되는 데이터를 저장할 수 있다.
    2. Set
        - 데이터의 순서(index)가 없다.
        - 중복되는 데이터를 저장할 수 없다.
     */
        HashSet<Object> hs1 = new HashSet<>();

        // Set 데이터 추가 = add() 메서드
        hs1.add("DD");
        hs1.add("BB");
        hs1.add(2);
        hs1.add(3);
        hs1.add("CC");
        hs1.add(1);
        hs1.add("AA");

        System.out.println("Set 데이터 개수 : "+hs1.size());
        System.out.println("Set 데이터 => : "+hs1);

        // Set 에 중복되는 데이터를 추가하면 false 를 반환하고 데이터 추가 안됨
        boolean isAdd = hs1.add("FF");
        System.out.println("중복되지 않을 때 : "+isAdd);
        System.out.println("Set 데이터 => : "+hs1);

        isAdd = hs1.add("AA");
        System.out.println("중복될 때 : "+isAdd);
        System.out.println("Set 데이터 => : "+hs1);

        // Set 데이터를 수정하려면 명령어가 존재하지 않아 데이터를 삭제하고 다시 추가해야 한다.
        // Set 삭제하는 메서드 : remove(삭제할 자료) ==> 반환값은 boolean
        // Set 전체 데이터 삭제 : clear()
        
        // "FF" 데이터를 "EE"로 변경하기
        hs1.remove("FF");
        System.out.println("삭제 후 Set => "+hs1);
        hs1.add("EE");
        System.out.println("Set 데이터 => "+hs1);
//        hs1.clear();
//        System.out.println("Set 의 클리어 후  : "+hs1);

        /*
        Set 의 데이터는 인덱스가 없어 1개씩 데이터를 불러올 수 없다.
        그래서 하나씩 얻기 위해서는 Iterator 형 객체로 변환해야 함
            - Set 형의 데이터들을 Iterator 형의 객체로 변환하는 메서드 ==> iterator()
         */

        Iterator it  = hs1.iterator();

        // ==> Iterator 의 데이터를 가르키는 포인터가 현재 위치의 다음에 데이터가 있는지 검사 있다면 true, 없다면 false
        while(it.hasNext()){
            // ==> Iterator 의 데이터를 가르키는 포인터의 다음 위치로 이동하고 이동 전 위치의 데이터 반환
            System.out.print(it.next()+" ");
        }
        System.out.println("\n----------------------------");
        
        // ────────────────────────────────────────────
        
        /*
            우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
            번호는 1~26이고 추첨 인원은 3명
            당첨자를 출력
         */

        randomType r = new randomType();
        HashSet<Integer> hs2 = new HashSet<>();
        while (hs2.size()<3) {
            hs2.add(r.range(1,26));
            // 중복이라면 데이터가 들어가지 않고 그렇다면 size 가 늘어나지 않아 다시 입력받게 한다.
        }
        System.out.println("hs2 = " + hs2);
    }
}






















