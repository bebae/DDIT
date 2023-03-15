import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class random{
	Random random = new Random();
	void name() {
		List<String> 성 = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
		        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
		        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "염", "양",
		        "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "기", "반", "왕", "금", "옥", "육");
		List<String> 이름 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
		        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "마", "만", "명", "무", "문", "미", "민", "바", "박",
		        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
		        "숭", "슬", "승", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
		        "유", "윤", "율", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
		        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
		        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
		        "솜", "공", "면", "탁", "온", "디", "후", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
		        "열", "웅", "분", "변", "양", "출", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
		        "흔", "람", "권", "복", "심", "헌", "엽", "학", "개", "평", "늘", "랑", "향", "울");
		
		Collections.shuffle(성);
	    Collections.shuffle(이름);
	    System.out.print(성.get(0) + 이름.get(0) + 이름.get(1));		
	}
	void address() {
		String[] city = {"대전시"};
		String[] gu = {"동구","중구","서구","유성구","대덕구"};
		String[] doug = {"대전로","고니1길","고니2길","이화로","백룡로","가양로","계족로","한남로","동서대로"};
		String[] jung = {"수도산로","중촌로","목동로","태평로","유천로","문화로","대둔산로","산서로","보문로"};
		String[] seo = {"도솔로","만년로","가수원로","갈마로","도산로","계백로","관저로","동서대로","배재로"};
		String[] yuseong = {"계룡로","갑동로","학하남로","대학로","문화원로","한밭대로","구즉로","신성로","봉산로"};
		String[] daedeok = {"대전로","한남로","오정로","계족로","중리로","송촌북로","화덕로","문평서로","신탄진로"};
		
		int randomX = random.nextInt(5);
	
		System.out.print(city[0]+" "+gu[randomX]+" ");
		switch (randomX) {
		case 0 :
			System.out.print(doug[random.nextInt(9)]+" ");
			break;
		case 1 :
			System.out.print(jung[random.nextInt(9)]+" ");
			break;
		case 2 :
			System.out.print(seo[random.nextInt(9)]+" ");
			break;
		case 3 :
			System.out.print(yuseong[random.nextInt(9)]+" ");
			break;
		case 4 :
			System.out.print(daedeok[random.nextInt(9)]+" ");
			break;
		}
		System.out.print((random.nextInt(1300)+10));
		
	}
	void telNum() {
		int tel1 = random.nextInt(9000) + 1000; //중간자리 4자리수 100~999
		int tel2 = random.nextInt(9000) + 1000; //마지막자리 4자리수 1000~9999
		
		System.out.print("010-"+tel1+"-"+tel2);
	}
	void carNum() {
		List<String> middleStr = Arrays.asList("가","나","다","라","마","바","사","아","자","거","너","더","러","머","버","서","어","저",
				"고","노","도","로","모","보","소","오","조","구","누","두","루","무","부","수","우","주","허","하","호");
		int frontNum = random.nextInt(10) < 1 ? random.nextInt(79)+1 : random.nextInt(600) + 100;
		int backNum = random.nextInt(9000) + 1000;
		
		Collections.shuffle(middleStr);
		System.out.print(frontNum+middleStr.get(0)+backNum);
	}
}

public class randomMaker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		random random = new random();
		
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
//			System.out.print("\'");
//			random.name();
//			System.out.print("\', \'");
//			random.address();
//			System.out.print("\', \'");
//			random.telNum();
//			System.out.println("\'");
			
//			System.out.print("\'");
//			random.carNum();
//			System.out.println("\'");
		}
		
		
		
	}

}
