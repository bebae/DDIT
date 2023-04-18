package main;

import java.io.*;
import java.util.*;




public class base {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		SelectMake sMake = new SelectMake();
		
		
		int selectNum = -1;
		boolean LoopOff = true;
		String Line = "──────────────────────";
		
		while (LoopOff) {
			
			
			bw.write(Line+"\n");
			bw.write("1. 쌍장요란 + 안전구축\n");
			bw.write("2. 덱 확인\n");
			bw.write("3. 앵화결투\n");
			bw.write("0. 종료\n");
			bw.write(Line+"\n");
			bw.flush();
			selectNum = Integer.parseInt(br.readLine());
			
			switch(selectNum) {
				case 0 : LoopOff = false;
				bw.write(" 프로그램을 종료합니다.");
				bw.flush();
				break;
				case 1 : 
					sMake.selectGoddess();
					sMake.makeDack();
				break;
				case 2 :
					sMake.selectDeak();
				break;
			}
		}
	}
}
	


















