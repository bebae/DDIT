package chapterMy;

import java.io.*;
import java.util.*;

class Rating {
	// 문자 받고 점수로 돌려주는 메소드
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean run = true;
		String text = "";
		double hagjeom = 0;

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int i = 0;
		while (st.hasMoreTokens()) {
			text = st.nextToken();
		
			bw.write(text+"\n");
			if (i%3 == 1) {
				hagjeom += Double.parseDouble(text);
			}
			if (i%3 == 2) {

			}
			bw.flush();
			i++;
		}
	}
}












