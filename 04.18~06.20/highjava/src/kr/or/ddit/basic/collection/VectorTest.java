package kr.or.ddit.basic.collection;

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
        System.out.println("'CCCC' 삭제 후 v1 => "+v1);
        System.out.println("삭제 반환 값 : "+r);

/*
        v1.remove(123);     // v1.remove 123을 데이터 int 123 이 아니라 index 값을 123으로 인식
        v1.remove(new Integer(123));        // 객체화 시켜서 삭제
*/
        v1.remove(Integer.valueOf(123));
        System.out.println("'123' 삭제 후 v1 => "+v1);
        System.out.println();

//        v1.remove('a');
        v1.remove(new Character('a'));
        System.out.println("'a'삭제 후 v1 => "+v1);

        v1.remove(true);
        System.out.println("ture 삭제 후 v1 => "+v1);

        v1.remove(3.14);
        System.out.println("3.14 삭제 후 v1 => "+v1);

        // 전체 데이터 삭제하기 : clear();
        v1.clear();
        System.out.println("clear 삭제 후 v1 => "+v1);
        System.out.println();

        /*
        제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때
                외부에서 지정해 주는 기법으로 객체를 선언할 때 <>괄호 안에 그 객체의 내부에서
                사용할 데이터의 타입을 정해주는 것을 말한다.
            - 이런 식으로 선언하게 되면 그 지정된 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
            - 이 때 제네릭으로 선언될 수 있는 데이터 타입은 클래스형 이어야 한다.
                그래서 int -> Integer, boolean -> Boolean, char -> Character 등으로 대체하여 사용
            - 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때도 별도의 형변환이 필요없다,
         */

        Vector<Integer> v2 = new Vector<>();
        Vector<String> v3 = new Vector<>();

        v3.add("안녕하세요");
        v3.add("100");
        
        String sTemp2 = v3.get(0);      // 형변환 없이 데이터 사용 가능


        Vector<Vector> vv = new Vector<>();
        Vector<Vector<Vector>> vvv = new Vector<>();
        System.out.println("\n-------------------------------\n");

        v3.clear();
        System.out.println("v3의 size = "+v3.size());
        v3.add("AAA");
        v3.add("BBB");
        v3.add("CCC");
        v3.add("DDD");
        v3.add("EEE");

        Vector<String> v4 = new Vector<>();
        v4.add("BBB");
        v4.add("EEE");

        System.out.println("v3 => "+v3);
        System.out.println("v4 => "+v4);

        /*
        데이터 삭제하기 3 : removeAll(Collection 객체)
        ==> 벡터의 데이터 중에서 'Collection 객체가 가지고 있는 모든 데이터를 삭제한다.
        ==> 반환값 boolean 타입
        */
        v3.removeAll(v4);
        System.out.println("v3에서 v4를 삭제 후 => "+v3);
        System.out.println("-------------------------------\n");

        v3.add(1,"BBB");
        v3.add(4,"EEE");

        // 벡터의 데이터들을 순서대로 모두 가져와 사용하기
        // 이 때는 반복문을 사용하면 된다. (주로 for)
        for (int i = 0; i < v3.size(); i++) {
            System.out.println(i+1+"번째 자료 : "+v3.get(i));
        }
        System.out.println("-------------------------------\n");

        // 향상된 for
        for (String temp : v3) {
            System.out.println(temp);
        }
    }
}


















