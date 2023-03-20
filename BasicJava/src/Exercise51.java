
public class Exercise51 {

	public static void main(String[] args) {
		
		int[] intArr = {38, 94, 16, 3, 76, 94, 82, 47, 59, 8};
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for (int i : intArr) {
			if (max < i) {
				max = i;
			}
			if (min > i) {
				min = i;
			}
		}
		System.out.println("최댓값: "+max);
		System.out.println("최솟값: "+min);
	}
}
