package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
    /*
        Map ==> key 값과 value 값을 한 쌍으로 관리하는 객체
            - key 값은 중복을 허용하지 않고 순서가 없다. (Set 특징)
            - value 값은 중복 허용
     */
        HashMap<String, String> map = new HashMap<>();

        // HashMap 자료 추가 => put(key, value)
        map.put("name", "홍길동");
        map.put("adder", "대전");
        map.put("tel", "010-1234-5678");
        System.out.println("map : "+map);

        // HashMap 자료 수정 => put(key, value)
        map.put("adder", "서울");
        map.put("tel", "010-1234-9999");
        System.out.println("map : "+map);

        // HashMap 자료 읽기 => get(key)
        System.out.println("name : "+map.get("name"));
        System.out.println("adder : "+map.get("adder"));
        System.out.println("별명 : "+map.get("nick"));

        // HashMap 자료 삭제=> remove(key)
        //      ==> 주어진 key 값과 같은 자료를 찾아서 삭제한다
        //      ==> 반환값 : 삭제된 자료의 'value' 값이 반환된다.
        String removeTel = map.remove("tel");
        System.out.println("map : "+map);
        System.out.println("removeTel : "+removeTel);

        // HashMap 자료 찾기 => containsKey(key)
        //      ==> 해당 key 값이 있으면 true 없으면 false 반환
        System.out.println("tel 존재여부 :  "+map.containsKey("tel"));
        System.out.println("name 존재여부 :  "+map.containsKey("name"));
        System.out.println("─────────────────────────────────────────────────────");

        // Map 에 저장된 모든 데이터를 읽어와서 사용하는 방법
        // 방법1 : Map 의 모든 key 값을 읽어와서 사용하는 방법
        // keySet() 메서드 ==> key 값들을 Set 형으로 반환한다.
        Set<String> keySet = map.keySet();

        // 방법 1-1 : Iterator 이용하기
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()) {
            String key = it.next();
            System.out.println(key+" : "+map.get(key));
        }
        System.out.println("─────────────────────────────────────────────────────");

        // 방법 1-2 : for~each 이용하기
        for(String key : keySet) {
            System.out.println(key+" : "+map.get(key));
        }
        System.out.println("─────────────────────────────────────────────────────");

        System.out.println("Map keySet 값 : "+map.keySet());
        for(String key : map.keySet()) {
            System.out.println(key+" : "+map.get(key));
        }
        System.out.println("─────────────────────────────────────────────────────");

        // 방법 2 : value  값만 읽어와서 처리하기
        //      ==> values() 메서드를 이용한다.
        for (String key: map.values()) {
            System.out.println(key);
        }
        System.out.println("─────────────────────────────────────────────────────");

        // key 값은 번호(int), value 값은 Member 인스턴스로 하는 Map 객체 생성하기
        HashMap<Integer, Member> memMap = new HashMap<>();
        memMap.put(1, new Member(1,"홍길동", "010-1111-1111"));
        memMap.put(2, new Member(2,"이순신", "010-2222-2222"));

        System.out.println("memMap 의 개수 : "+memMap.size());
        System.out.println("memMap : "+memMap);


    }

}
