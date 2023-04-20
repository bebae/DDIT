package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
    public static void main(String[] args) {
        ArrayList<Member> memList = new ArrayList<>();

        memList.add(new Member(1, "홍길동", "010-1111-1111"));
        memList.add(new Member(5, "이순신", "010-2222-2222"));
        memList.add(new Member(9, "성춘향", "010-3333-3333"));
        memList.add(new Member(3, "변학도", "010-4444-4444"));
        memList.add(new Member(6, "일지매", "010-5555-5555"));
        memList.add(new Member(2, "강감찬", "010-6666-6666"));

        System.out.println("정렬 전");
        for (Member mem : memList) {
            System.out.println(mem);
        }
        System.out.println("===============================================");

        Collections.sort(memList);
        System.out.println("정렬 후");
        for (Member mem : memList) {
            System.out.println(mem);
        }
        System.out.println("===============================================");

        // 데이터 섞기
        Collections.shuffle(memList);

        System.out.println("섞기 후");
        for (Member mem : memList) {
            System.out.println(mem);
        }
        System.out.println("===============================================");

        // Member 의 회원번호(num) 값의 내침차순으로 정렬하는 외부 정렬 기준 클래스를 작성하세요
        // ==> Comparator 인터페이스를 구현 (클래스명 : SortNumDesc)
        Collections.sort(memList, new SortNumDesc());
        
        System.out.println("숫자 정렬 후");
        for (Member mem : memList) {
            System.out.println(mem);
        }
        System.out.println("===============================================");

    }
}


class Member implements Comparable<Member> {
    private int num;
    private String name;
    private String tel;

    public Member(int num, String name, String tel) {
        this.num = num;
        this.name = name;
        this.tel = tel;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member" + "num=" + num +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'';
    }

    @Override
    public int compareTo(Member member) {
        return getName().compareTo(member.getName());
    }
}
class SortNumDesc implements Comparator<Member> {
    @Override
    public int compare(Member mem1, Member mem2) {
//        if (mem1.getNum() > mem2.getNum()) {
//            return -1;
//        } else if (mem1.getNum() < mem2.getNum()) {
//            return 1;
//        }
//        return 0;
        return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
    }
}









