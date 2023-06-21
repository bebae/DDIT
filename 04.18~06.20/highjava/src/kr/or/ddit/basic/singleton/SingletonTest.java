package kr.or.ddit.basic.singleton;

public class SingletonTest {
    public static void main(String[] args) {
//        MySingleton s1 = new MySingleton();       // 외부에서 new 객체 불가

        // 객체 생성 없이 메소드 호출
        MySingleton.getInstance().displayText();

        // 객체 생성은 getInstance()메소드를 호출해서 생성
        MySingleton s2 = MySingleton.getInstance();
        s2.displayText();

        System.out.println(s2 == MySingleton.getInstance());

        System.out.println(s2.hashCode());
        System.out.println(MySingleton.getInstance().hashCode());
    }

}
