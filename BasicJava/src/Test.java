import java.util.Scanner;

class quest{
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
		Scanner sc = new Scanner(System.in);
		
		quest quest = new quest();
		
		quest.page128N4();
		quest.page129N6();
		quest.page129N8();
		quest.page129N9();
		quest.page130N10();
		
	}

}
