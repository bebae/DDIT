package chapter02;

public class VariableExchangeExample {
	
	static void prit(int x, int y) {
		System.out.println("x:"+x+"y:"+y);
	}

	
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		prit(x,y);
		
		int temp = x;
		x = y;
		y = temp;
		prit(x, y);
		
		x = x+y;
		y = x-y;
		x = x-y;
		prit(x, y);
		
		x = x+y;
		y = x-y;
		x = x-y;
		prit(x, y);
	}
}

