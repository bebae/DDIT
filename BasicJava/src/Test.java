import java.util.*;
import java.io.*;

class chapter05 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	void p201N6() throws IOException {
		boolean run = true;
		int[] scores = null;
		
		while (run) {
			bw.write("--------------------------------------------------------\n");		
			bw.write(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			bw.write("--------------------------------------------------------\n");
			bw.write("선택> ");
			bw.flush();
			int selectNo = Integer.parseInt(br.readLine());
			
			switch (selectNo) {
			case 1:
				bw.write("학생수> ");
				bw.flush();
				scores = new int[Integer.parseInt(br.readLine())];
				break;
			case 2:
				for (int i = 0; i < scores.length; i++) {
					bw.write("scores["+i+"]> ");
					bw.flush();
					scores[i] = Integer.parseInt(br.readLine());
				}
				break;
			case 3:
				for (int i = 0; i < scores.length; i++) {
					bw.write("scores["+i+"]> "+scores[i]+"\n");
				}
				break;
			case 4:
				int sum=0, max=0;
				double avg=0.0;
				for (int i : scores) {
					sum += i;
					if (max < i) {
						max = i;
					}
				}
				avg = (double)(sum)/(double)(scores.length);
				bw.write("최고 점수: "+max+"\n");
				bw.write(String.format("평균 점수: %.4f", avg));
				break;
			case 5:
				run = false;
				bw.write("프로그램 종료");
				break;
			default:
				break;
			}
			bw.flush();
		}
		br.close();
		bw.close();
	}
	void p201N5() throws IOException {
		int[][] array = {{95,86},{83,92,96},{78,83,93,87,88}};
		int sum = 0;
		double avg = 0.0;
		
		for (int[] is : array) {
			for (int is2 : is) {
				sum += is2;
				avg++;
			}
		}
		avg = (double)sum/(double)avg;
		
		bw.write("sum: "+sum+"\n");
		bw.write(String.format("avg: %.2f", avg));
		bw.flush();
	}
	void p200N4() throws IOException {
		int max = 0;
		int[] array = {1,5,3,8,2};
		
		for (int i : array) {
			if (max < i) {
				max = i;
			}
		}
		bw.write("max: "+max);
		bw.flush();
	}
}

class chapter04{
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	void p161N7() {
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
	void p161N6_2() {
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
	void p161N6_1() {
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
	void p161N6() {
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
	void p161N5() {
		System.out.print("입력 :");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	void p161N4() {
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (60 == 4*i+5*j) {
					System.out.println("("+i+", "+j+")");
				}
			}
		}
	}
	void p161N3() {
		int x=0, y=0;
		while (x+y != 5) {
			x = rd.nextInt(6)+1;
			y = rd.nextInt(6)+1;
			
			System.out.println("("+x+", "+y+")");
		}
	}
	void p160N2() {
		int sum=0;
		for (int i = 0; i <= 100 && i%3 == 0; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}

class chapter03{
	Scanner sc = new Scanner(System.in);
	void p130N11() {
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
	void p130N10() {
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
//		double var4 = var1 * var1 * var2 + "." + var3;
		double var4 = var1 * var1 * (var2+((double)(var3)/100));
		
		System.out.println("원의 넓이:"+var4);
	}
	void p129N9() {
		double num1 = 0, num2 = 0;
		num1 = Math.round((Math.random()*10)*100)/100.0;
		System.out.println("첫 번째 수: "+num1);
		num2 = Math.round((Math.random()*5)*100)/100.0;
		System.out.println("두 번째 수: "+num2);
		System.out.println("-------------------");
		System.out.println("결과:"+(!(num2==0)?Math.round(num1/num2*100)/100.0:"무한대"));
	}
	void p129N8() {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthBottom+lengthTop)*height/2.0;
		System.out.println(area);
	}
	void p129N6() {
		int value = 365;
		System.out.println(value / 100 * 100);
	}
	void p128N4() {
		int pencils = 534;
		int students = 30;
		
		// 학생 1명이 가지는 연필 개수
		int pencilsPerStudent = (pencils/30);
		System.out.println(pencilsPerStudent);
		
		// 남은 연필 개수
		int pencilsLeft = pencils%30;
		System.out.println(pencilsLeft);
	}
	void p126() {
		int score = (int) (Math.random()*50+50);
		char grade = score > 90 ? 'A' : score > 80 ? 'B' : score > 70 ? 'C' : score > 60 ? 'D' : 'F';
		System.out.println(score+"점 "+grade+"등급");
	}
}

public class Test {
	public static void main(String[] args) throws IOException {
		chapter03 ch03 = new chapter03();	
		chapter04 ch04 = new chapter04();
		chapter05 ch05 = new chapter05();
		
//		ch04.p161N6();
		ch05.p201N6();
		
	}
}
