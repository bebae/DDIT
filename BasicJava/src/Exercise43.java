import java.util.Scanner;

public class Exercise43 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int program = Integer.parseInt(sc.nextLine());
		System.out.print("데이터베이스: ");
		int db = Integer.parseInt(sc.nextLine());
		System.out.print("화면 구현: ");
		int ui = Integer.parseInt(sc.nextLine());
		System.out.print("애플리케이션 구현: ");
		int app = Integer.parseInt(sc.nextLine());
		System.out.print("머신러닝: ");
		int machine = Integer.parseInt(sc.nextLine());
		
		int total = program+db+ui+app+machine;
		double ave = total/5.0;
		char grade = ave >= 90 ? 'A' : ave >= 80 ? 'B' : ave >= 70 ? 'C' : ave >= 60 ? 'D' : 'F';
		
		System.out.printf("총점: %d\n평균: %.1f\n학점: %s",total,ave,grade);
	}
}
