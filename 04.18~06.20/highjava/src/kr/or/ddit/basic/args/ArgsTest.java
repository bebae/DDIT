package kr.or.ddit.basic.args;

public class ArgsTest {
    public static void main(String[] args) {
        ArgsTest at = new ArgsTest();

        System.out.println("sum = " + at.sumArr(new int[] {100,200,300}));
        System.out.println("──────────────────────────────────────────────────");
        System.out.println(at.sumArg(1,2,3,4,5));
        System.out.println(at.sumArg(100,200,300));
        System.out.println("──────────────────────────────────────────────────");
        System.out.println(at.sumArg2("홍길동",10,20,30));
        System.out.println("──────────────────────────────────────────────────");
        System.out.println(at.sumAll(1,2,"3","헝",10,34-3));
    }
    /*
        가변형 인수는 메소드 안에서는 배열로 처리된다.
        가변형 인수는 한개의 메소드의 한가지 자료형만 사용할 수 있다.
        가변형 인수와 일반적인 인수와 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
     */
    public Object sumAll(Object...objects){
        Number sum = 0;
        for (Object datum : objects) {
            if(datum instanceof Number) {
                sum = sum.doubleValue() + ((Number) datum).doubleValue();
            }
        }
        return sum;
    }

    // 가변형 인수를 이용한 메소드
    public int sumArg(int ...date){
        int sum = 0;
        for (int datum : date) {
            sum += datum;
        }
        return sum;
    }
    public String sumArg2(String name, int ...date){
        int sum = 0;
        for (int datum : date) {
            sum += datum;
        }
        return name+"씨의 합계는 "+sum+" 입니다.";
    }

    public int sumArr(int[] data){
        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        return sum;
    }
}
