import java.util.Random;
import java.util.Scanner;

class chapter04{
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	void page161N7() {
		boolean run = true;
		int balance = 0;
		
		while (run) {
			System.out.println("-----------------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1 :
				System.out.print("예금액>");
				balance += Integer.parseInt(sc.nextLine());
				break;
			case 2 :
				System.out.print("출금액>");
				balance -= Integer.parseInt(sc.nextLine());
				break;
			case 3 :
				System.out.print("잔고>");
				System.out.println(balance);
				break;
			default :
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
	void page161N6_2() {
		System.out.print("입력 :");
		int N = sc.nextInt()*2;
		
		for (int i = 1; i < N; i+=2) {
			for (int j = N-1; j > i; j-=2) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	void page161N6_1() {
		System.out.print("입력 :");
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	void page161N6() {
		System.out.print("입력 :");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i+j > N-2){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	void page161N5() {
		System.out.print("입력 :");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	void page161N4() {
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (60 == 4*i+5*j) {
					System.out.println("("+i+", "+j+")");
				}
			}
		}
	}
	void page161N3() {
		int x=0, y=0;
		while (x+y != 5) {
			x = rd.nextInt(6)+1;
			y = rd.nextInt(6)+1;
			
			System.out.println("("+x+", "+y+")");
		}
	}
	void page160N2() {
		int sum=0;
		for (int i = 0; i <= 100 && i%3 == 0; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

class chapter03{
	Scanner sc = new Scanner(System.in);
	void page130N11() {
		System.out.print("아이디: ");
		String name = sc.nextLine();
		
		System.out.print("패스워드: ");
		String strPasswordString = sc.nextLine();
		int password = Integer.parseInt(strPasswordString);
		
		if("java".equals(name)) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
	}
	void page130N10() {
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
//		double var4 = var1 * var1 * var2 + "." + var3;
		double var4 = var1 * var1 * (var2+((double)(var3)/100));
		
		System.out.println("원의 넓이:"+var4);
	}
	void page129N9() {
		double num1 = 0, num2 = 0;
		num1 = Math.round((Math.random()*10)*100)/100.0;
		System.out.println("첫 번째 수: "+num1);
		num2 = Math.round((Math.random()*5)*100)/100.0;
		System.out.println("두 번째 수: "+num2);
		System.out.println("-------------------");
		System.out.println("결과:"+(!(num2==0)?Math.round(num1/num2*100)/100.0:"무한대"));
	}
	void page129N8() {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthBottom+lengthTop)*height/2.0;
		System.out.println(area);
	}
	void page129N6() {
		int value = 365;
		System.out.println(value / 100 * 100);
	}
	void page128N4() {
		int pencils = 534;
		int students = 30;
		
		// 학생 1명이 가지는 연필 개수
		int pencilsPerStudent = (pencils/30);
		System.out.println(pencilsPerStudent);
		
		// 남은 연필 개수
		int pencilsLeft = pencils%30;
		System.out.println(pencilsLeft);
	}
	void page126() {
		int score = (int) (Math.random()*50+50);
		char grade = score > 90 ? 'A' : score > 80 ? 'B' : score > 70 ? 'C' : score > 60 ? 'D' : 'F';
		System.out.println(score+"점 "+grade+"등급");
	}
}

public class Test {
	public static void main(String[] args) {
		chapter03 ch03 = new chapter03();	
		chapter04 ch04 = new chapter04();
		
//		ch04.page161N6();
		
	}
}
