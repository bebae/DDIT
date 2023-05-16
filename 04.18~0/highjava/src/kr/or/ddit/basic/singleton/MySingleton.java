package kr.or.ddit.basic.singleton;

/**
 * Singleton 패턴
 * 1. 자신 class의 참조값이 저장될 변수를 private static으로 선언한다.
 * 2. 모든 생성자의 접근 제한자를 private로 한다.
 * 3. 자신 class의 인스턴스를 생성하고 반환하는 메소드를 public static으로 작성한다.(getInstance())
 */
public class MySingleton {
    // 1번 자신의 class 참조값 변수
    private static MySingleton single;

    // 2번 생성자 접근 제한자 제한
    private MySingleton() {
        System.out.println("싱글톤 객체 생성자 부분 출력!");
    }
    
    // 3번 자신 class 인스턴스를 만들고 반환하는 메소드
    public static MySingleton getInstance() {
        if(single == null) single = new MySingleton();
        return single;
    }


    public void displayText() {
        System.out.println("Hello, Singleton!");
    }


    
}
