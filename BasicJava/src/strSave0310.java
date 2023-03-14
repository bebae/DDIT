import java.util.Iterator;
import java.util.Scanner;

public class strSave0310 {
	/* 
	 * ZZAZBA를 입력 받으면 처음에 Z를 저장하고 그 다음 문자인 Z를 첫 번째 Z와 비교하여 같으면
	 * 첫 번째 Z값에 대응하는 count에 +1, 다르다면 +0
	 * 세 번째 문자인 A를 앞의 문자들과 비교하여 같은 문자가 있다면, 
	 * 그 문자에 대응하는 count에 +1 아니라면 새로운 count 추가하여 +1
	 * 최고값 count 문자를 출력하고 만약 최고값 count가 2개 이상이라면 ? 출력
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		//	문자열을 입력받고 대문자로 변환
		String str= sc.nextLine().toUpperCase();
		
		//	문자열 count을 저장할 Int배열 생성
		int[] arrInt = new int [str.length()]; 

		int max = 0;			// 문자열 count 중 가장 많은 수
		char strMax = ' ';		// 가장 많이 나온 문자
		int duplication = 0;	// 중복체크
		arrInt[0] = 1;

/*
		//	for문 용 i
		int i=0;
		//	문자열의 두번째 값을 첫번째 값과 비교
		if (arrChar[i] == arrChar[i+1]) {
			// 같다면
			arrInt[i]++;
		} else {
			// 다르다면 다음 빈도수 배열값으로 넘어가 +1
			arrInt[i+1]++;
		}
		
		//	문자열의 셋번째 값을 첫번째 값과 두번째 값과 비교
		if (arrChar[i] == arrChar[2] || arrChar[1] == arrChar[2]) {
			arrInt[i]++;
		} else {
			// 다르다면 다음 빈도수 배열값으로 넘어가 +1
			arrInt[i+1]++;
		}
*/
		
		// 문자열 n번째 값을 0번째 부터 n-1번째 까지 비교
		// j는 비교할 문자 j2는 중복 확인 앞의 문자
		for (int j = 0; j < arrInt.length; j++) {
			for (int j2 = 0; j2 < j; j2++) {
				// j2 = 0 ; j2 < 1; j2++ => 첫번째 문자(j2)와 두번째 문자(j) 비교
				// j2 = 0 ; j2 < 2; j2++ => 1,2번째 문자(j2)와 세번째 문자(j) 비교
				if (str.charAt(j2) == str.charAt(j)) {
					// 만약 n번째 값과 같은 값이 나온다면 비교한 문자의 Int 값 증가
					arrInt[j2]++;
					// 그리고 ZZZ 처럼 중복될 수도 있으니 여기서 이 루프 탈출
					break;			
				} else if (j2 == j-1) {
					// 아무것도 중복되지 않는다면 Int값을 새로만듦
					arrInt[j]++;
				}
			}
		}
		for (int j = 0; j < arrInt.length; j++) {
			// 가장 count이 높은 구하고 그 값을 변수에 저장
			if (arrInt[j] > max ) {
				max = arrInt[j];
				strMax = str.charAt(j);
			}
		}	
		
		// aabc, abbc, abcc(특히 조심!)
		
		for (int j = 0; j < arrInt.length; j++) {
			if (arrInt[j] == max) {
				duplication++;
			}
		}
		
		System.out.println("입력한 문자열 중 가장 많은 문자는 "+strMax+"입니다.");
		
		// 출력값 확인
		for (int j = 0; j < arrInt.length; j++) {
			System.out.print(str.charAt(j)+" ");
		}
		System.out.println();
		for (int j = 0; j < arrInt.length; j++) {
			System.out.print(arrInt[j]+" ");
		}
		System.out.println();
		
		System.out.println("max : "+max+" / strMax : "+strMax+" / 최대중복값 : "+ duplication);
		System.out.println(duplication > 1 ? "?" : strMax);
	}
}









