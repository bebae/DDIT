package problem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class lottoSet {
    public static void main(String[] args) {

        int lottoPrice = 1000;              // 로또 하나 가격
        int maxLottoCount = 100;            // 1인당 최대 로또 구매 개수
        int userMoney = 0;                  // 입력한 금액
        int lottoCount = 0;                 // 금액으로 살 수 있는 로또 개수

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        HashSet<Integer> lottoSet = new HashSet<>();                // while 문 밖에 있어야 메모리를 최소한으로 사용할 수 있음
        
        // 로또 구매 메뉴 출력
        while (true) {
            System.out.println("==========================");
            System.out.println("\tLotto 프로그램");
            System.out.println("--------------------------");
            System.out.println(" 1. Lotto 구입");
            System.out.println(" 2. 프로그램 종료");
            System.out.println("==========================");
            System.out.print("메뉴선택 : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\n Lotto 구입 시작\n");
                    System.out.println("(1000원에 로또번호 하나입니다.)");
                    System.out.print("금액 입력 : ");
                    userMoney = sc.nextInt();

                    if (userMoney < lottoPrice) {
                        System.out.println("\n입력 금액이 너무 적습니다. 로또번호 구입 실패!!!\n");
                        break;
                    }

                    lottoCount = userMoney / lottoPrice;

                    if (lottoCount > maxLottoCount) {
                        System.out.println("\n입력 금액이 너무 많습니다. 로또번호 구입 실패!!!\n");
                        break;
                    }

                    // 로또 번호 출력
                    System.out.println("\n행운의 로또번호는 아래와 같습니다.");
                   for (int i = 1; i <= lottoCount; i++) {
                       while (lottoSet.size() < 6) {
                           lottoSet.add(rand.nextInt(45) + 1);
                       }
//                    Iterator<Integer> lottoInter = lottoSet.iterator();         // 다중 입력 시 프로그램이 점점 느려짐. 메모리 문제 발생!
                       int index = 0;

                       System.out.print("로또번호" + i + " : ");
                       for (int j = 0; j < 6;j++) {
                           System.out.print(lottoSet.toArray()[index++]);
                           if (j < 5) {
                               System.out.print(", ");
                           }
                       }
                       System.out.println();
                       lottoSet.clear();
                   }


                    // 거스름돈 계산
                    int change = userMoney - (lottoCount * lottoPrice);
                    System.out.println("\n받은 금액은 " + userMoney + "원이고 거스름돈은 " + change + "원입니다.\n");
                    break;
                case 2:
                    System.out.println("\n감사합니다");
                    return;
                default:
                    System.out.println("\n잘못된 메뉴 선택입니다. 다시 선택해주세요.\n");
                    break;
            }
        }
    }
}
