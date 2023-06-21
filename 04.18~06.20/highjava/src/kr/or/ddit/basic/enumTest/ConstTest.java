package kr.or.ddit.basic.enumTest;

public class ConstTest {
    //상수 선언하기
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int BLUE = 3;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;

    public static void main(String[] args) {
        int color = ConstTest.RED;
        System.out.println(color);

        color = ConstTest.GREEN;
        System.out.println(color);

        color = ConstTest.BLUE;
        System.out.println(color);

        color = ConstTest.ONE;
        System.out.println(color);

        color = ConstTest.TWO;
        System.out.println(color);

        color = ConstTest.THREE;
        System.out.println(color);

    }
}
