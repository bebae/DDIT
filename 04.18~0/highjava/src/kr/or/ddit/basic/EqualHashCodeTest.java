package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualHashCodeTest01 {
    public static void main(String[] args) {
        Peson p1 = new Peson();
        p1.setId(1);
        p1.setName("홍길동");

        Peson p2 = new Peson();
        p2.setId(1);
        p2.setName("홍길동");

        Peson p3 = p1;

        System.out.println(p1 == p2);
        System.out.println(p1 == p3);
        System.out.println(p1.equals(p2));

        HashSet<Peson> set1 = new HashSet<>();
        set1.add(p1);
        set1.add(p2);
        System.out.println("Set 의 개수 : "+set1.size());

        System.out.println("p1 hashcode : "+p1.hashCode());
        System.out.println("p2 hashcode : "+p2.hashCode());
        System.out.println("p3 hashcode : "+p3.hashCode());

    }
}
/*
    - equals() 메서드    => 두 객체의 내용이 같은지를 비교하는 메서드  ==> 동등성
    - hashCode() 메서드  => 두 객체가 같은 객체인지를 비교하는 메서드  ==> 동일성

    - Hashtable, HashMap, HashSet 과 같이 Hash 로 시작하는 컬렉션 객체들은
      객체의 의미상의 동일성 비교를 위해서 hashCode() 메서드를 호출하여 비교한다.
      그러므로 객체가 같은지 여부를 결정하려면 equals() 메서드와 hashCode()메서드를 같이 재정의 해야 한다.

    - hashCode() 메서드에서 사용하는 '헤싱 알고리즘'은 서로 다른 객체들에 대해 같은 hashCode 값을 만들어 낼 수 있다.
 */

class Peson{
    private int id;
    private String name;

    public Peson(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {                          // 참조값이 같다면
            return true;
        }
        if (obj == null){                           // 오브젝트 낫 널
            return false;
        }
        if (this.getClass() != obj.getClass()){     // 같은 유형의 클래스 확인
            return false;
        }

        Peson p = (Peson) obj;
        return this.id == p.id && Objects.equals(this.name, p.name);
//        return this.id == p.id && this.name.equals(p.name);

    }
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
