package chapterMy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class keywordCount {
	/*
     *  입력받은 문자열 중 키워드와 맞는 수 만큼 세고, 키워드에 아닌 문자도 1개씩 세는 코드
     */
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 찾을 키워드 저장 배열
		String word[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str = br.readLine();

		// 저장한 배열에 저장된 키워드 만큼 반복
		for(String search : word) {
			// 입력된 문자열에 중복이 없을 때까지 반복
            while(str.contains(search)) {
            	// 입력된 문자열 중 키워드와 맞는 문자열 중 첫번째를 "1"로 변환
            	str = str.replaceFirst(search,"1");
            }
		}
		// 문자열의 길이를 출력
        System.out.println(String.valueOf(str.length()));
	
        
	}
}












