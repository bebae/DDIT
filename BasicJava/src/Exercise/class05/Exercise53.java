package Exercise.class05;
import java.util.Random;
import java.util.Scanner;

public class Exercise53 {

	public static void main(String[] args) {
		Random random = new Random();
		
		String[] aiCom = {"가위","바위","보"};
		String aiValue = aiCom[random.nextInt(aiCom.length)];
		String result = null;
		
		System.out.print("가위 바위 보를 입력하세요: ");
		String inPut = new Scanner(System.in).nextLine();
		
		System.out.println("게이머 :"+inPut);
		System.out.println("인공지능 컴퓨터: "+aiValue);
		
		if (inPut.equals(aiValue)) {
			result = "무승부";
		} else if("가위".equals(inPut) && "보".equals(aiValue) 
				||"바위".equals(inPut) && "가위".equals(aiValue)
				||"보".equals(inPut) && "바위".equals(aiValue)) {
			result = "게이머 승리";
		} else {
			result = "컴퓨터 승리";
		}
		System.out.println("결과: "+result+"!");
	}
}
