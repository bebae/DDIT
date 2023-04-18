package Exercise;
import java.util.Scanner;

public class Exercise31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요: ");
		int a = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하세요: ");
		int b = sc.nextInt();
		
		int bigNum = ((a+b) + Math.abs(a-b)) / 2;
		int smallNum = ((a+b) - Math.abs(a-b)) / 2;
		
		System.out.println("큰 수를 작은 수로 나눈 몫은 "+bigNum/smallNum+"이고, 나머지는 "+bigNum%smallNum+"이다.");
	}
}
