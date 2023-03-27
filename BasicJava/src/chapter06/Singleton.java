package chapter06;

public class Singleton {
	// 필드 / private 외부 접근 불가 / static은 메소드 영역에 할당 
	// class 이름과 같음(Singleton) / instance는 필드 이름
	private static Singleton instance;
	
	// instance 값을 리턴 / 클래스 이름 / private가 붙지 않아서 외부에서 접근 가능
	public static Singleton getInstance() {
		if (instance == null) {
			// instance 값이 널이라면 생성
			instance = new Singleton();
		}
		return instance;
	}
	
	// 기본 생성자에 외부에서 호출할 수 없게 private 붙임
	private Singleton() {}
}
