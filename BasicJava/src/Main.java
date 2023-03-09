import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		num = sc.nextInt();
		int x = num * 2 - 1;
		
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				if(i < x/2) {					// 위쪽
					if(i+j <= x/2-1)				// 왼쪽 위 공백
						System.out.println(" ");
					else if(j-i>=x/2+1)				// 오른쪽 위 공백
						System.out.println(" ");
					else 
						System.out.println("*");
				} else {						// 아래쪽
					if(i-j >= x/2+1)				// 왼쪽 밑 공백
						System.out.println(" ");
					else if(i+j >= x/2*3+1)			// 오른쪽 밑 공백
						System.out.println(" ");
					else 
						System.out.println("*");	
				}
			}
		}
	}
}
