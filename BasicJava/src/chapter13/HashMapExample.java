package chapter13;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        // MAP 컬랙션 생성
        Map<String, Integer> map = new HashMap<String, Integer>();

        // 객체 저장
        map.put("신용권",85);
        map.put("홍길동",90);
        map.put("동장군",80);
        map.put("홍길동",95);
        System.out.println("총 Entry 수: "+map.size());

        // 객체 찾기
        System.out.println("\t홍길동의 점수: "+map.get("홍길동")+"\n");

        // 모든 데이터 찾기
        // 1. Entry를 이용하는 방식
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        // 1-1. iterator 방식
        Iterator<Map.Entry<String, Integer>> integers = entrySet.iterator();
        while (integers.hasNext()) {
            Map.Entry<String, Integer> e = integers.next();
            System.out.println(e);
        }
        // 1-2. foreach 방식
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        // 2. key를 이용하는 방식
        Set<String> keySet = map.keySet();
        // 2-1. iterator 방식
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key+" = "+map.get(key));
        }
        // 2-2. foreach 방식
        for (String key : keySet) {
            System.out.println(key+" = "+map.get(key));
        }
        System.out.println();
        // 3. value를 이용하는 방식
        Collection<Integer> values = map.values();
        for (Integer value: values) {
            System.out.println(values);
        }

        // MAP 안 데이터 확인
        System.out.println(map);

    }
}
