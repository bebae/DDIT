package kr.or.ddit.basic;

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

    }
}

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
}
