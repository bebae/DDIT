package chapter07.exam02;

public class Tire {
	// 필드
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	// 생성자
	public Tire(String location, int maxRatation) {
		this.location = location;
		this.maxRotation = maxRatation;
	}
	
	// 메소드
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location+"Tire 수명: "+(maxRotation-accumulatedRotation)+"회");
			return true;
		} else {
			System.out.println("*** "+location+" Tire 펑크 ***");
			return false;
		}
	}
}
