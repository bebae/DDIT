package chapter13;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP                                                                                                ");
        set.add("Java");
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체수: "+size);

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String element = it.next();
            System.out.println("\t"+element);
        }
        
        set.remove("JDBC");
        set.remove("iBATIS");

        System.out.println("총 객체수: "+set.size());

        it = set.iterator();
        for (String element : set) {
            System.out.println("\t"+element);
        }
        // 함수형 프로그래밍 jdk 1.8에서 Stream APT 함수형
        // 속도가 foreach문 보다 느림
        set.forEach(System.out::println);

        set.clear();
        if (set.isEmpty()){
            System.out.println("비어 있음");
        }

    }
}
