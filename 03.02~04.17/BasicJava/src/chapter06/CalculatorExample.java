package chapter06;

class Calculator {
	//메소드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
}

public class CalculatorExample {

	public static void main(String[] args) {
			Calculator myCalc = new Calculator();
			myCalc.powerOn();
			
			int result = myCalc.plus(5, 6);
			System.out.println("result1: "+result);
			
			byte x = 10;
			byte y = 4;
			double result2 = myCalc.divide(x, y);
			System.out.println("result2: "+result2);
			
			myCalc.powerOff();
	}

}
