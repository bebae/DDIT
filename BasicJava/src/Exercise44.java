import java.util.Scanner;

public class Exercise44 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위 바위 보 게임");
		System.out.print("철수: ");
		String cheolsu = sc.nextLine();
		System.out.print("영희: ");
		String younghee = sc.nextLine();
		
		String game = "";
		
		if ("가위".equals(cheolsu)) {
			if ("가위".equals(younghee)) {
				game = "무승부";
			} else if ("바위".equals(younghee)) {
				game = "영희 승리";
			} else if ("보".equals(younghee)) {
				game = "철수 승리";
			}
		} else
		if ("바위".equals(cheolsu)) {
			if ("가위".equals(younghee)) {
				game = "철수 승리";
			} else if ("바위".equals(younghee)) {
				game = "무승부";
			} else if ("보".equals(younghee)) {
				game = "영희 승리";
			}
		} else
		if ("보".equals(cheolsu)) {
			if ("가위".equals(younghee)) {
				game = "영희 승리";
			} else if ("바위".equals(younghee)) {
				game = "철수 승리";
			} else if ("보".equals(younghee)) {
				game = "무승부";
			}
		}
		System.out.println("결과: "+game+"!");
	}
}









