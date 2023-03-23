package Exercise;
import java.util.Scanner;

public class Exercise24 {
	
	public static void main(String[] args) {
		
		double radius=0, height=0, area=0, volume=0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("원기둥 밑변의 반지름을 입력하시오.(단위: cm) :");
		radius = Double.parseDouble(sc.nextLine());

		System.out.print("원기둥 높이를 입력하시오.(단위: cm) :");
		height = Double.parseDouble(sc.nextLine());
		
		area = radius*radius*Math.PI;
//		area = Math.pow(radius, 2)*Math.PI;
		volume = area*height;
		
		System.out.printf("원기둥 밑변의 넓이는 %.14fcm², 원기둥의 부피는 %.13fcm³이다.", area, volume);
	}
}
