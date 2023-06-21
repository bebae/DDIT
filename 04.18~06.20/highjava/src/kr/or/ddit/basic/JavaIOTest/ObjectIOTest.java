package kr.or.ddit.basic.JavaIOTest;

import java.io.*;
import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectIOTest {
    public static void main(String[] args) throws Exception {
        Member mem1 = new Member("홍길동",20,"대전");
        Member mem2 = new Member("홍길남",30,"서울");
        Member mem3 = new Member("홍길서",40,"인천");
        Member mem4 = new Member("홍길북",50,"부산");

        FileOutputStream fout = new FileOutputStream("d:/D_Other/object.bin");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        
        // 쓰기 작업
        System.out.println("쓰기 작업 시작");
        oout.writeObject(mem1);
        oout.writeObject(mem2);
        oout.writeObject(mem3);
        oout.writeObject(mem4);
        oout.writeObject(null);

        System.out.println("=====================");

        oout.close();
        bout.close();
        fout.close();

        // 객체 입력용 스트림 객체 생성
        ObjectInputStream oin = new ObjectInputStream(
                new BufferedInputStream(Files.newInputStream(Paths.get("d:/D_Other/object.bin")))
        );
        Object obj = null;

        System.out.println("객체 읽기 작업 시작");
        while((obj = oin.readObject()) != null) {
            Member mem = (Member)obj;
            System.out.println("이름 : "+mem.getName());
            System.out.println("나이 : "+mem.getAge());
            System.out.println("주소 : "+mem.getAddr());
            System.out.println("=====================");
        }
        System.out.println("읽기 자료 완료");
        oin.close();

    }
    
    private static class Member implements Serializable {
        private final String name;
        private final int age;
        private final String addr;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddr() {
            return addr;
        }

        public Member(String name, int age, String addr) {
            this.name = name;
            this.age = age;
            this.addr = addr;
        }

        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
        }
    }
}
