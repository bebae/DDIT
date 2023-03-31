package chapterMy;

import java.io.*;
import java.util.*;

public class randomType {
	Random random = new Random();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	void name() throws IOException {
		List<String> 성 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
		        "송", "류", "전", "홍", "고", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
		        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "원", "천", "방", "공", "강", "양",
		        "여", "추", "도", "소", "신", "석", "설", "마", "길", "주", "연", "표", "기", "반", "금", "육");
		List<String> 이름 = Arrays.asList("강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "다",
		        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "마", "명", "무", "문", "미", "민", "박",
		        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "수", "숙", "순",
		        "슬", "승", "신", "아", "안", "엄", "여", "연", "영", "예", "옥", "완", "요", "용", "우", "원", "월", "위",
		        "유", "윤", "율", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
		        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
		        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "림", "혼", "황", "린", "을", "비",
		        "솜", "공", "탁", "온", "후", "균", "송", "욱", "휴", "언", "섬", "추", "삼",
		        "열", "웅", "분", "양", "출", "흥", "겸", "곤", "식", "란", "손", "술", "반", "빈", "실",
		        "람", "권", "복", "심", "헌", "엽", "학", "평", "늘", "울", "");
		
		Collections.shuffle(성);
	    Collections.shuffle(이름);
	   bw.write(성.get(0) + 이름.get(0) + 이름.get(1));	
	   bw.flush();
	}
	void address() throws IOException {
		String[] city = {"대전시"};
		String[] gu = {"동구","중구","서구","유성구","대덕구"};
		String[] doug = {"대전로","고니1길","고니2길","이화로","백룡로","가양로","계족로","한남로","동서대로"};
		String[] jung = {"수도산로","중촌로","목동로","태평로","유천로","문화로","대둔산로","산서로","보문로"};
		String[] seo = {"도솔로","만년로","가수원로","갈마로","도산로","계백로","관저로","동서대로","배재로"};
		String[] yuseong = {"계룡로","갑동로","학하남로","대학로","문화원로","한밭대로","구즉로","신성로","봉산로"};
		String[] daedeok = {"대전로","한남로","오정로","계족로","중리로","송촌북로","화덕로","문평서로","신탄진로"};

		int randomGu = random.nextInt(5);
	
		bw.write(city[0]+" "+gu[randomGu]+" ");
		switch (randomGu) {
		case 0 :
			bw.write(doug[random.nextInt(9)]+" ");
			break;
		case 1 :
			bw.write(jung[random.nextInt(9)]+" ");
			break;
		case 2 :
			bw.write(seo[random.nextInt(9)]+" ");
			break;
		case 3 :
			bw.write(yuseong[random.nextInt(9)]+" ");
			break;
		case 4 :
			bw.write(daedeok[random.nextInt(9)]+" ");
			break;
		}
		bw.write(random.nextInt(1300)+10);
		bw.flush();
	}
	void telNum() throws IOException {
		int tel1 = random.nextInt(9000) + 1000; //중간자리 4자리수 1000~9999
		int tel2 = random.nextInt(9000) + 1000; //마지막자리 4자리수 1000~9999
		
		bw.write("010-"+tel1+"-"+tel2);
		bw.flush();
	}
	void carNum() throws IOException {
		List<String> middleStr = Arrays.asList("가","나","다","라","마","바","사","아","자","거","너","더","러","머","버","서","어","저",
				"고","노","도","로","모","보","소","오","조","구","누","두","루","무","부","수","우","주","허","하","호");
		int frontNum = random.nextInt(10) < 1 ? random.nextInt(79)+1 : random.nextInt(600) + 100;
		int backNum = random.nextInt(9000) + 1000;
		
		Collections.shuffle(middleStr);
		bw.write(frontNum+middleStr.get(0)+backNum);
		bw.flush();
	}
	void SocialSecurityNumber() throws IOException {
		int year = random.nextInt(30)+1970;
		int month = random.nextInt(12)+1;
		int date = 0;
		int gender = 0;
		int backNumber = 0;
		
		switch (month) {
		case 2: 
			date = random.nextInt(29)+1;
			break;
		case 4: case 6: case 9: case 11: 
			date = random.nextInt(30)+1;
			break;
		default:
			date = random.nextInt(31)+1;
			break;
		}
		
		switch (year/100) {
		case 19:
			gender = random.nextInt(2)+1;
			backNumber = (random.nextInt(96)+1)*10000;
			backNumber += (random.nextInt(99)+1)*100;
			backNumber += (random.nextInt(3)+1)*10;
			backNumber += random.nextInt(9)+1;
			break;
		case 20:
			gender = random.nextInt(2)+3;
			backNumber = random.nextInt(999999)+1;
			break;
		default:
			gender = random.nextInt(4)+5;
			backNumber = random.nextInt(999999)+1;
			break;
		}
		
		bw.write(String.format("%d%02d%02d-%d%06d", year, month, date, gender, backNumber));
		bw.flush();
	}
	void numberArr() throws IOException {
		int num = 5;
		for (int i = 0; i < num; i++) {
			bw.write(String.valueOf(random.nextInt(10)));
		}
		bw.flush();
	}
	void stringArr() throws IOException {
		List<String> 배열1 = Arrays.asList("AB","BB","CB","DC","EC","XZ");
		List<String> 배열2 = Arrays.asList("A","B","C","D","E","F");
		Collections.shuffle(배열1);
		Collections.shuffle(배열2);
		int num = random.nextInt(999)+1;
		
		bw.write(String.format(배열1.get(0)+"%03d",num));
		bw.flush();
	}
	
}















