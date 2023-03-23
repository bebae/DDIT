package Exercise;
import java.util.Random;

public class Exercise52A {
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int[] lotto = new int[45];
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (i+1); 
		}
		
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < lotto.length; i++) {
				int temp = 0;
				int address = random.nextInt(45);
				temp = lotto[i];
				lotto[i] = lotto[address];
				lotto[address] = temp;
			}
		
			for (int i = 0; i < 6; i++) {
				System.out.printf((i == 0 ? "" : ", ")+"%2d",lotto[i]);
			}
			System.out.println();
		}
	}
}
