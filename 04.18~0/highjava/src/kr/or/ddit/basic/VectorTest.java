package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        // 객체 생성
        Vector v1 = new Vector();
        System.out.println("처음 크기 : " +v1.size());

        // 데이터 추가하기 1 : add(추가할 데이터)
        // 반환값 : 추가성공(true), 추가실패(false)
        v1.add("aaa");
        v1.add(new Integer(100));
        v1.add(123);    // 오토박싱
        v1.add('a');
        v1.add(true);
        boolean r = v1.add(3.14);

        System.out.println("현재 크기 : "+v1.size());
        System.out.println("반환값 : "+r);
        System.out.println("v1 => " + v1);
        
        // 데이터 추가하기 2 : addElement(추가할 데이터)
        // ==> 이전 번전의 프로그램과의 호환성을 위해서 남아있는 메소드
        v1.addElement("CCCC");
        System.out.println("v1 => "+v1);

        // 데이터 추가하기 3 : add(index, 데이터)
        // ==> 'index'번째에 '데이터'를 끼워 넣는다.
        // ==> 'index'는 0부터 시작하고 반환값은 없다.
        v1.add(1, "KKKK");
        System.out.println("v1 => "+v1);

        // 데이터 꺼내오기 : get(index)
        // ==> 'index'번째 데이터를 꺼내서 반환한다.
        System.out.println("0번재 데이터 :"+v1.get(0));
        int iTemp = (int)v1.get(2);
        System.out.println("2번째 데이터 : "+iTemp);
        System.out.println();

        // 데이터 수정하기 : set(index, 새로운 데이터)
        // ==> 'index'번째 데이트를 '세로운 데이터'로 변경한다.
        // ==> 반환값 : 원래의 데이터
        String sTemp = (String)v1.set(0, "zzzzz");
        System.out.println("v1 => "+v1);
        System.out.println("원래의 데이터 : "+sTemp);
        System.out.println();

        // 데이터 삭제하기 1 : remove(index)
        // ==> 'index' 번째 데이터를 삭제한다.
        // ==> 반환값 : 삭제된 데이터
        sTemp = (String) v1.remove(0);
        System.out.println("삭제 후 v1 => "+v1);
        System.out.println("삭제된 데이터 : "+sTemp);

        // 데이터 삭제하기 2 : remove(삭제할 데이터)
        // ==> '삭제할 데이터'를 찾아서 삭제한다.
        // ==> 삭제할 데이터가 Vector 안에 여러개라면 첫번째 자료 삭제
        // ==> 반환값 삭제성공(true), 삭제실패(false)
        r = v1.remove("CCCC");
        System.out.println("삭제 후 v1 => "+v1);
        System.out.println("삭제 반환 값 : "+r);

//        v1.remove(123);     // v1.remove 123을 데이터 int 123 이 아니라 index 값을 123으로 인식
        v1.remove(new Integer(123));
        System.out.println("삭제 후 v1 => "+v1);

    }
}


















