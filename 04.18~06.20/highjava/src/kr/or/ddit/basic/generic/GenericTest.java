package kr.or.ddit.basic.generic;

class NonGeneric{
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
/*
    제네릭을 적용한 클래스 만드는 방법
    형식)
        class 클래스명<제네릭타입> {
            private 제네릭타입 변수명;          // 변수 선언에 제네릭을 사용한 경우
            ...

            // 반환값이 있는 경우
            public 제네릭타입 메소드명(매개변수들...) {
                ...
                return 제네릭타입의 반환값;
            }
            // 반환값이 없는 경우
            public void 메소드명(매개변수들...) {
                ...
            }
        }

        // 제네릭 타입 ==> 영문자 대문자 1글자로 표기한다.
        T ==> Type
        K ==> Key
        V ==> Value
        E ==> Element
        N ==> Number
        S ==> String
 */
class MyGeneric <T> {       // MyGeneric<String>으로 하면 T 자리가 다 String 으로 치환된다
    private T value;

    public T getObj() {
        return value;
    }

    public void setObj(T value) {
        this.value = value;
    }
}
public class GenericTest {
    public static void main(String[] args) {
        NonGeneric ngl = new NonGeneric();
        ngl.setObj("hello");

        NonGeneric ng2 = new NonGeneric();
        ng2.setObj(10);

        String str = (String)ngl.getObj();
        int num = (int)ng2.getObj();
        System.out.println(str);
        System.out.println(num);
        System.out.println("─────────────────────────────────────────────────");

        MyGeneric<String> mg1 = new MyGeneric<>();
        MyGeneric<Integer> mg2 = new MyGeneric<>();

        mg1.setObj("hello");
        mg2.setObj(10);

        String str2 = mg1.getObj();
        int num2 = mg2.getObj();

        System.out.println(str2);
        System.out.println(num2);
        System.out.println("─────────────────────────────────────────────────");
        NonGeneric ng3 = new NonGeneric();
        ng3.setObj("ABCDE");
//        int a = (int)ng3.getObj();        // 런타임 오류가 발생하지만 컴파일 단계에선 오류가 발견되지 않음

        MyGeneric<String> mg3 = new MyGeneric<>();
        mg3.setObj("ABCDE");
        String b = mg3.getObj();
        System.out.println(b);
        System.out.println("─────────────────────────────────────────────────");
    }
}










