import java.util.Scanner;

public class Exercise33 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("윤년인지를 확인할 연도를 입력하세요: ");
		int leapYear = sc.nextInt();
		
		String yesNo = (leapYear % 4 == 0) && (leapYear % 100 != 0) || (leapYear % 400 == 0) ? "맞습니다." : "아닙니다.";
		
		System.out.print(leapYear+"은 윤년이 " + yesNo);
	}
}
