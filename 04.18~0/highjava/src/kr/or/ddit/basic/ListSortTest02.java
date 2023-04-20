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
        System.out.println("===========================================");

        Collections.sort(memList);
        System.out.println("정렬 후");
        for (Member mem : memList) {
            System.out.println(mem);
        }
        System.out.println("===========================================");

        // 데이터 섞기
        Collections.shuffle(memList);

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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









