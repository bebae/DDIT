package kr.or.ddit.basic.collection;

import My.randomType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortStudentTest {
    /*
    문제) 학번, 이름, 국어, 영어, 수학, 총점, 등수를 멤버로 갖는 Student 클래스를 만든다.
    이 Student 의 생성자에서는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아 초기화 한다.

    이 Student 객체는 List 에 저장하여 관리한다.

    List 에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
    총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력

    등수는 List 에 전체 데이터가 추가된 후에 구해서 저장되도록 한다. (StudentTest 클래스 처리)
     */
    public void createRank(ArrayList<Student> rankList){
        for (Student std1 : rankList) {
            int rank = 1;
            for (Student std2 : rankList) {
                if (std1.getTotal() < std2.getTotal()) {
                    rank++;
                }
            }
            std1.setRank(rank);
        }
    }

    public static void main(String[] args) throws IOException {
        String line = "────────────────────────────────────────────────────────────────────────────────";
        randomType rdType = new randomType();

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(104, rdType.name(true), rdType.range(50, 100), rdType.range(50, 100), rdType.range(50, 100)));
        studentList.add(new Student(105, rdType.name(true), rdType.range(50, 100), rdType.range(50, 100), rdType.range(50, 100)));
        studentList.add(new Student(103, rdType.name(true), rdType.range(50, 100), rdType.range(50, 100), rdType.range(50, 100)));
        studentList.add(new Student(101, rdType.name(true), rdType.range(50, 100), rdType.range(50, 100), rdType.range(50, 100)));
        studentList.add(new Student(107, rdType.name(true), rdType.range(50, 100), rdType.range(50, 100), rdType.range(50, 100)));

        ListSortStudentTest lst = new ListSortStudentTest();
        lst.createRank(studentList);

        System.out.println("정렬전");
        for (Student st : studentList) {
            System.out.println(st);
        }
        System.out.println(line);

        Collections.sort(studentList);          // 학번 내부 정렬 int 오름차순

        System.out.println("학번 정렬후");
        for (Student st : studentList) {
            System.out.println(st);
        }
        System.out.println(line);

        studentList.sort(new SortByTotal());   // 총점 외부 정렬 int 내림차순
        System.out.println("총점 정렬후");
        for (Student st : studentList) {
            System.out.println(st);
        }
        System.out.println(line);

    }
}

class Student implements Comparable<Student> {
    private int sno;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int total;
    private int rank;

    public Student(int sno, String name, int kor, int eng, int math) {
        this.sno = sno;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = kor + eng + math;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("Student sno=%d, name='%s', kor =%3d, eng =%3d, math =%3d, total=%d, rank=%d",
                sno, name, kor, eng, math, total, rank);
    }


    // 내부 정렬 기준 사용 int 오름차순
    // this 와 .get 을 비교
    @Override
    public int compareTo(Student std) {
        // 학번의 오름차순
        return Integer.compare(this.sno, std.getSno());
    }
}

// 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스
 class SortByTotal implements Comparator<Student> {
    @Override
    public int compare(Student std1, Student std2) {
        if (std1.getTotal() == std2.getTotal()) {                           // 총점이 같다면
            return std1.getName().compareTo(std2.getName());                // 이름의 오름차순
        } else {                                                            // 같지 않으면
            return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;  // 총점을 내림차순
        }
    }
}