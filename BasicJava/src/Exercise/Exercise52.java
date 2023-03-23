package Exercise;
import java.util.Random;

public class Exercise52 {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] intArr = new int [6];
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = random.nextInt(45)+1;
			for (int j = 0; j < i; j++) {
				if (intArr[j] == intArr[i]) {
					i--;
					break;
				}
			}
		}
		for (int i : intArr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
