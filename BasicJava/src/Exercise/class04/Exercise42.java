package Exercise.class04;
import java.util.Scanner;

public class Exercise42 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String season = "";
		
		System.out.print("월을 입력하세요(1~12):");
		int month = Integer.parseInt(sc.nextLine());
		
		switch (month) {
		case 3: case 4: case 5:
			season = "봄";
			break;
		case 6: case 7: case 8:
			season = "여름";
			break;
		case 9: case 10: case 11:
			season = "가을";
			break;
		case 12: case 1: case 2:
			season = "겨울";
			break;
		default:
			season = "잘못된 입력";
			break;
		}
		System.out.println(month+"월은 "+season+"입니다.");
	}
}





