package main;

import java.util.List;
import java.util.Scanner;


class selectMake {
	Scanner sc = new Scanner(System.in);
	
	void selectGoddess() {
		int select = -1;
		boolean LoopOff = true;
		int[] duo = new int[2];
		int selectRound = 0;
		String[] goddessList = {"뒤로가기","유리나","사이네","토코요","히미카"};
		int arrayMax = goddessList.length;
		
		
		while (LoopOff) {
			System.out.println("선택해주세요.");
			System.out.println("─────────────────");
			for (int i = 1; i < arrayMax; i++) {
				System.out.println(i+". "+goddessList[i]);
			}
			System.out.println("0. 뒤로가기");
			System.out.println("─────────────────");
			
			select = sc.nextInt();
			if (select == duo[0]) {
				System.out.println("같은 값을 선택할 수 없습니다.");
				continue;
			}
			if (selectRound == 0 || selectRound == 1 && select >= 0 && select < arrayMax) {
				duo[selectRound] = select;
				selectRound++;
				System.out.println(goddessList[select]+"를 선택하셨습니다.");
			} else {
				System.out.println("입력값이 잘못되었습니다.");
				continue;
			}
			
			if (selectRound >= 2) {
				switch(select) {
				case 0 : 
					LoopOff = false; break;
				case 1 : 
				case 2 :
				case 3 :
				case 4 :
					System.out.println(goddessList[duo[0]]+" / "+goddessList[duo[1]]);
				}
				LoopOff = false;
			}	
		}
	}
	void makeDack() {
		
	}
}

public class base {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int selectNum = -1;
		boolean LoopOff = true;
		
		selectMake sMake = new selectMake();
		
		while (LoopOff) {
			
			System.out.println("─────────────────");
			System.out.println("1. 쌍장요란 + 안전구축");
			System.out.println("2. 앵화결투");
			System.out.println("0. 종료");
			System.out.println("─────────────────");
			selectNum = sc.nextInt();
			
			switch(selectNum) {
				case 0 : LoopOff = false;
					System.out.println("프로그램을 종료합니다.");
					break;
				case 1 : sMake.selectGoddess(); break;
			}
		

		}
		
		
	}

}



















