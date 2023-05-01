package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class racingTest {

    public static int rank = 1; // 경기에서 말의 등수를 나타내는 변수

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>(); // 말 객체를 담을 리스트 생성
        for (int i = 1; i <= 10; i++) {
            horses.add(new Horse(String.format("%2d번말",i))); // 말 객체 생성 후 리스트에 추가
        }

        for (Horse horse : horses) { // 모든 말 객체를 순회하며 경주 시작
            horse.start();
        }

        try {
            for (Horse horse : horses) { // 모든 말 객체가 경주를 마칠 때까지 대기
                horse.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.sort(horses); // 말 객체를 등수에 따라 정렬

        System.out.println("경기 끝!!!");
        for (Horse horse : horses) { // 모든 말 객체의 등수 출력
            System.out.println(horse.getHorseName() + " : " + horse.getRank() + "등");
        }
    }

    public static class Horse extends Thread implements Comparable<Horse> {

        private final String name; // 말 이름
        private int position; // 말이 달린 거리
        private int rank; // 각 말의 등수를 저장하는 변수

        public Horse(String name) {
            this.name = name;
        }

        public String getHorseName() {
            return name;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getRank() {
            return rank;
        }

        public void printPosition() { // 현재 말의 위치를 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 50; i++) {
                if (i == position) {
                    sb.append(">");
                } else {
                    sb.append("-");
                }
            }
            System.out.println(name + " : " + sb);
        }

        @Override
        public int compareTo(Horse o) { // 말 객체를 등수에 따라 정렬하기 위한 메소드
            return Integer.compare(rank, o.rank);
        }

        @Override
        public void run() { // 말이 경주를 시작하는 메소드
            for (int i = 1; i <= 50; i++) { // 말이 달리는 거리를 50으로 설정
                setPosition(i);
                printPosition();
                try {
                    Thread.sleep((int) (Math.random() * 500)); // 말이 랜덤한 시간 동안 쉬지 않고 달리도록 설정
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setRank();
        }

        public synchronized void setRank() { // 말의 등수를 설정하는 메소드
            this.rank = racingTest.rank++; // 전역 변수 rank를 사용하여 등수를 설정하고 증가시킴
        }
    }
}