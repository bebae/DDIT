package chapterMy;

import java.io.*;

public class randomMaker {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		randomType random = new randomType();
		
		bw.write("입력 : ");
		bw.flush();
		String num = br.readLine();
		
		for (int i = 0; i < Integer.parseInt(num); i++) {
			//random.numberArr();	// 무작위 랜덤 숫자 배열

			bw.write("'");
			bw.flush();
			random.stringArr();
			
			bw.write("', '");
			bw.flush();
			
			random.name(ture);
			
			bw.write("', '");
			bw.flush();
			
			random.telNum();
			
//			random.carNum();
			
			bw.write("'");
			bw.newLine();
			bw.flush();
		}
		
		br.close();
	}
}




