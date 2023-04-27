package kr.or.ddit.basic.enumTest;

/*
 *  Enum(Enumeration) 열겨형
 *          서로 관련있는 상수들의 집합을 나타낸다.
 *          클래스처럼 보이게 하는 상수
 *  만드는 방법
 *          열거형은 클래스처럼 독립된 java 파일에 만들 수 있고,
 *          하나의 java 파일에 클래스와 같이 만들 수 있고,
 *          클래스 안에 내부 클래스처럼 만들 수 있다.
 *  열거형의 속성과 메소드
 *          name() : 열거형 상수의 이름을 문자열로 반환한다.
 *          ordinal() : 열거형 상수가 정의된 순서(index)값을 반환한다. (0부터 시작)
 *          valueOf("열거형상수명") : 지정된 열거형에서 "상수명"과 일치하는 상수를 반환한다.
 *          values() : 열거형에 선언된 모든 상수들을 배열로 반환한다.
 *          열거형이름.상수명 : valueOf()와 같은 의미
 *
 *  열거형 선언하기
 *  방법1)
 *          enum 열거형이름 {상수명1, 상수명2, ... }
 *  방법2)
 *          enum 열거형이름 {
 *              상수명1 (값들);
 *              상수명2 (값들);
 *           }
 *          // '값들'을 저장할 변수들을 선언
 *          private 자료형이름 변수명1;
 *          private 자료형이름 변수명2;
 * 
 *          // 열거형의 생성자를 만들기(선언한 값을 변수에 저장할 역할)
 *          private 열거형이름(자료형이름 변수명1, ...) {
 *              this.변수명1 = 변수명1;
 *          }
 */
public class EnumTest {
    public enum Color {RED, GREEN, BLUE}
    public enum Count {ONE, TWO, THREE}
    public enum Season {
        SPRING("3월부터 5월까지", 13),
        SUMMER("6월부터 8월까지", 25),
        FALL("9월부터 11월까지",15),
        WINTER("12월부터 2월까지",1);

        private String span;
        private int temp;
        Season(String span, int temp) {
            this.span = span;
            this.temp = temp;
        }
        public String getSpan() {
            return span;
        }
        public int getTemp() {
            return temp;
        }
        @Override
        public String toString() {
            return String.format("%4s 평균기온 : %2d도", span, temp);
        }
    }
    public static void main(String[] args) {
        Color mycol = Color.GREEN;
        Count mycnt = Count.ONE;
        System.out.println("mycol : "+mycol.name());
        System.out.println("mycnt : "+mycnt.name());
        System.out.println();

        System.out.println("mycol ordianl : "+mycol.ordinal());
        System.out.println("mycnt ordinal : "+mycnt.ordinal());
        
        if(mycol == Color.BLUE) {
            System.out.println("같다");
        } else {
            System.out.println("다르다");
        }

        // 열거형은 switch 도 가능
        // 열거형이름.상수이름이 아니라 상수이름만 입력해야 함
        switch (mycnt) {
            case ONE :
                System.out.println("ONE 입니다 "); break;
        }
        System.out.println("--------------------------------------");

        Season myseason = Season.valueOf("SPRING");
        System.out.println("my season name : "+myseason.name());
        System.out.println("ordinal : "+myseason.ordinal());
        System.out.println("span : "+myseason.getSpan());
        System.out.println("temp : "+myseason.getTemp());
        System.out.println("--------------------------------------");

        for(Season season : Season.values()) {
            System.out.println(season.name() + " : " +season);
        }

    }
}
















