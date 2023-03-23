package main;

import java.util.HashMap;
import java.util.Scanner;

class SelectMake {
	Scanner sc = new Scanner(System.in);
	
	String Line = "───────────────────";
	int[] duo = new int[2];
	String[] goddessList = {"뒤로가기","유리나","사이네","히미카","토코요"};
	String[] goddessName = {"yurina","saine"};
	String[] yurina = {"참","일섬","자루치기","거합","기백","압도","기염만장","월영락","해안의 파랑일며","쪽배에서 쉬노니","아마네 유리나의 저력"};
	String[] saine = {"팔방 휘두르기","후려베기","무게추","간파","권역","충음벽","무음벽","율동호극","항명공진","음무쇄빙","히사메 사이네의 최후의 종극"};
	String[] himika = {"슛","레피드 파이어","매그넘 캐논","풀 버스트","백스텝","백드래프트","스모크","레드 불릿","크림슨 제로","스칼렛 이매진","버밀리온 필드"};
	String[] tokoyo = {"빗어내리기","우아한 타격","날뛰는 토끼","시의 춤","부채 뒤집기","바람의 무대","맑음의 무대","영원의 꽃","천년의 새","무궁의 바람","상세의 달"};
	String[] makeDackArr = new String [10];
	
	// HashMap 키값과 그에 대응하는 밸류값을 저장하고 가져오는 함수
	HashMap<Integer, String[]> godMap = new HashMap<Integer, String[]>() {
		private static final long serialVersionUID = 1L;
	{
		put(1, yurina);
		put(2, saine);
		put(3, himika);
		put(4, tokoyo);
	}};
	
	void selectGoddess() {
		int select = -1;
		boolean LoopOff = true;
		int selectRound = 0;
		int arrayMax = goddessList.length;
		
		
		while (LoopOff) {
			System.out.println(" 선택해주세요.");
			System.out.println(Line);
			for (int i = 1; i < arrayMax; i++) {
				System.out.println(i+". "+goddessList[i]);
			}
			System.out.println("0. 뒤로가기");
			System.out.println(Line);
			
			select = Integer.parseInt(sc.nextLine());
			if (select == duo[0]) {
				System.out.println(" 같은 값을 선택할 수 없습니다.");
				continue;
			}
			if (selectRound == 0 || selectRound == 1 && select >= 0 && select < arrayMax) {
				duo[selectRound] = select;
				selectRound++;
				System.out.println(" "+goddessList[select]+"를 선택하셨습니다.");
			} else {
				System.out.println(" 입력값이 잘못되었습니다.");
				continue;
			}
			
			if (selectRound >= 2) {
				switch(select) {
				case 0 : 
					LoopOff = false; break;
				default :
					System.out.println(goddessList[duo[0]]+" / "+goddessList[duo[1]]);
				}
				LoopOff = false;
			}	
		}
	}

	void makeDack() {
		String[] godName = {};
		
		boolean loop = true;
		int deakMaxNum = 11;
		
		System.out.println(Line);
		System.out.println(" 안전구축을 시작합니다.");
		System.out.println(" "+goddessList[duo[0]]+" / "+goddessList[duo[1]]);
		System.out.println(Line);
		
		System.out.println(" 패 목록");
		for (int i = 0; i < 2; i++) {
			godName = godMap.get(duo[i]);
			System.out.println(Line);
			for (int j = 0; j < deakMaxNum; j++) {
				if(i<1) System.out.println((j+1)+". "+godName[j]);
				else System.out.println((j+12)+". "+godName[j]);
			}
		}
		
		System.out.println(Line);
		System.out.println("카드 선택(통상패 7장, 비장패 3장)");
		int i = 0;
		
		while (loop) {
			int selectNum = 0;
			Boolean ckBoolean = false;
			
			selectNum = Integer.parseInt(sc.next())-1;
			
			// 선택한 번호 범위 && 
			if(selectNum >= 0 && selectNum < deakMaxNum*2+1) {
				
				godName = (selectNum < deakMaxNum) ? godMap.get(duo[0]) : godMap.get(duo[1]);
				
				for (int j = 0; j < makeDackArr.length && makeDackArr[j] != null ; j++) {
					if (godName[selectNum % deakMaxNum] == makeDackArr[j]) {
						System.out.println("중복선택");
						ckBoolean = true;
						i--;
					}
				}
			
				System.out.println(godName[selectNum % deakMaxNum]);
				if (!ckBoolean)
					makeDackArr[i] = godName[selectNum % deakMaxNum];
				
			} else {
				continue;
			}

			// 덱 최대 범위(10장)가 넘어가면 while문 종료
			if (++i+1 >= deakMaxNum) {
				loop = false;
			}
		}
	}
	
	void selectDeak() {
		for (int i = 0; i < makeDackArr.length; i++) {
			System.out.printf("%2d. %s\n",i+1,makeDackArr[i]);
			System.out.printf(i==6 ? "비장패\n" : "");
		}
	}
}


















