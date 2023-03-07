import java.util.Scanner;

public class Exercise25_정범진 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int coin500 = 0, coin100 = 0, coin50 = 0, coin10 = 0;
		int sum = 0;
		
		System.out.print("500원짜리 동전의 갯수: ");
		coin500 = Integer.parseInt(sc.nextLine());
		
		System.out.print("100원짜리 동전의 갯수: ");
		coin100 = Integer.parseInt(sc.nextLine());
		
		System.out.print("50원짜리 동전의 갯수: ");
		coin50 = Integer.parseInt(sc.nextLine());
		
		System.out.print("10원짜리 동전의 갯수: ");
		coin10 = Integer.parseInt(sc.nextLine());
		
		sum = coin500*500+coin100*100+coin50*50+coin10*10;
		System.out.printf("저금통 안의 동전의 총 액수: %,d원", sum);
	}
}
