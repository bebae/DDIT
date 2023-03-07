import java.util.Scanner;

public class Exercise21_정범진 {

	public static void main(String[] args) {
		
		double width=0, height=0, area=0, perimeter=0;
		Scanner sc = new Scanner(System.in);
	
		System.out.print("가로의 길이는?(단위: m) :");
		width = Double.parseDouble(sc.nextLine());

		System.out.print("세로의 길이는?(단위: m) :");
		height = Double.parseDouble(sc.nextLine());
		
		area = width*height;
		perimeter = width*2+height*2;
		
		System.out.printf("직사각형의 넓이: %.2f\n", area);
		System.out.printf("직사각형의 둘레: %.2f\n", perimeter);
	}
}
