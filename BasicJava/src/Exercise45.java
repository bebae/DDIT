import java.util.Random;
import java.util.Scanner;

public class Exercise45 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int choice = 0, count=0;
		int randomNum = rd.nextInt(100)+1;
		
		while (true) {
			System.out.print("1부터 100 사이의 정수 중 하나를 선택하세요: ");
			choice = Integer.parseInt(sc.nextLine());
			count++;
			
			if (choice < randomNum) {
				System.out.println("정답은 더 큰 수입니다.");
			} else if (choice > randomNum) {
				System.out.println("정답은 더 작은 수입니다.");
			} else if (choice == randomNum) {
				System.out.println("정답입니다. "+count+"번 만에 맞췄습니다.");
				break;
			}
		}
		System.out.println("게임을 종료합니다.");
	}
}
