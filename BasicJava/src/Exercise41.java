import java.util.Scanner;

public class Exercise41 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max=0, twoSum=0;
		boolean possible = false;
		
		System.out.print("삼각형의 첫번째 변의 길이를 입력하세요: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("삼각형의 두번째 변의 길이를 입력하세요: ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("삼각형의 세번째 변의 길이를 입력하세요: ");
		int num3 = Integer.parseInt(sc.nextLine());
		
		if (num1 > max) {
			max = num1;
			twoSum = num2+num3;
		}
		if (num2 > max) {
			max = num2;
			twoSum = num1+num3;
		}
		if (num3 > max) {
			max = num3;
			twoSum = num1+num2;
		}
		if (twoSum > max) {
			possible = true;
		} else {
			possible = false;
		}
		
		System.out.print("삼각형을 만들 수 ");
		System.out.println(possible ? "있습니다." : "없습니다.");
	}
}
