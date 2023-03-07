
public class Exercise22_정범진 {

	public static void main(String[] args) {
		
		double distance = 40e12;
		double lightSpeed = 300000;
		double value = distance/lightSpeed/60/60/24/365;
		
		System.out.printf("빛의 속도로 프록시마 센타우리까지 간다면 시간은 %.15f광년이다.\n", value);

	}

}
