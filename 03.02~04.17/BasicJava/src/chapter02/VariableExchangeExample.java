package chapter02;

class Tool{
	public void prit(int x, int y) {
		System.out.println("x:"+x+"y:"+y);
	}
}

public class VariableExchangeExample {
		
	public static void main(String[] args) {
	
		Tool t = new Tool();
		
		int x = 3;
		int y = 5;
		t.prit(x,y);
		
		int temp = x;
		x = y;
		y = temp;
		t.prit(x, y);
		
		x = x+y;
		y = x-y;
		x = x-y;
		t.prit(x, y);
		
		x = x+y;
		y = x-y;
		x = x-y;
		t.prit(x, y);
	}
}

