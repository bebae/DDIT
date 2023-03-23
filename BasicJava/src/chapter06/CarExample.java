package chapter06;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Car {
	//필드
		int gas;
		
		//생성자
		
		//메소드
		void setGas(int gas) {
			this.gas = gas;
		}
		
		boolean isLeftGas() {
			if(gas==0) {
				System.out.println("gas가 없습니다."); 
				return false;
			}
			System.out.println("gas가 있습니다."); 
			return true;
		}
		
		
		void run() {
			while(true) {
				if(gas > 0) {
					System.out.println("달립니다.(gas잔량:" + gas + ")");
					gas -= 1;
				} else {
					System.out.println("멈춥니다.(gas잔량:" + gas + ")");
					return;
				}
			}
		}
}

public class CarExample {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Car myCar = new Car();
		
		myCar.setGas(5);
		
		boolean gasState = myCar.isLeftGas();
		if (gasState) {
			bw.write("출발합니다.\n");
			bw.flush();
			myCar.run();
		}
		
		if (myCar.isLeftGas()) {
			bw.write("gas를 주입할 필요가 없습니다.");
		} else {
			bw.write("gas를 주입하세요.");
		}
		bw.flush();
	}

}















