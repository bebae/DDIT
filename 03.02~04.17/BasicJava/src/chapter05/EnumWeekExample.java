package chapter05;
import java.io.*;
import java.util.Calendar;

public class EnumWeekExample {
public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);		// 일(1) ~ 토(7) 숫자를 리턴
		Week today = null;
		
		switch (week) {
		case 1:
			today = Week.SUNDAY;	break;
		case 2:
			today = Week.MONDAY;	break;
		case 3:
			today = Week.TUESDAY;	break;
		case 4:
			today = Week.WEDNESDAY;	break;
		case 5:
			today = Week.THURSDAY;	break;
		case 6:
			today = Week.FRIDAY;	break;
		case 7:
			today = Week.SATURAY;	break;
		default:
			break;
		}
		
		if(today == Week.SUNDAY) {
			bw.write("일요일에는 게임을 합니다.\n");
		} else {
			bw.write("열심히 자바 공부를 합니다\n");
		}
		
		bw.write(String.valueOf(today.korName)+"\n");
		bw.write(String.valueOf(today.ordinal()));
		bw.flush();
		
		
		
		bw.write(String.valueOf(Week.SUNDAY));
		
	
	}
}
