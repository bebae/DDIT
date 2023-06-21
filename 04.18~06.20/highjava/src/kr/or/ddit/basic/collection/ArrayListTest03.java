package kr.or.ddit.basic.collection;

import My.randomType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
    public static void main(String[] args) throws IOException {
        /*
        5명의 별명을 입력받아 ArrayList 에 저장하고 별명들 중에
        별명의 길이가 제일 긴 별명을 출력(단, 각 별명의 길이는 모두 다르게 입력한다.)
         */
        ArrayList<String> nicknames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        randomType rt = new randomType();
        // 별명 입력 받기
        for (int i = 1; i <= 5; i++) {
            System.out.print("별명 " + i + "을 입력하세요: ");
            String nickname = sc.nextLine();
            nicknames.add(nickname);
        }

        // 별명 중 길이가 가장 긴 것 찾기
        String longestNickname = "";
        for (String nickname : nicknames) {
            if (nickname.length() > longestNickname.length()) {
                longestNickname = nickname;
            }
        }

        // 결과 출력
        System.out.println("가장 긴 별명: " + longestNickname);
    }
}
