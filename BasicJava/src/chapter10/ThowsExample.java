package chapter10;

public class ThowsExample {

    // throws   => 메소드를 호출한 곳으로 예외를 던진다.
    // throw    => 예외를 개발자가 만든다.
    // s가 붙으면 method가 예외를 던지고, throw는 개발자가 예외를 만들어 던진다.
    public static void main(String[] args) {
        try {
//            findClass();
            throw new Exception();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        } catch (Exception e) {
          e.printStackTrace();
            System.err.println("사용 중 에러 발생. 관리자 문의 바랍니다.");
        }
//        findClass();
    }

    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.long.String2");
    }
}
