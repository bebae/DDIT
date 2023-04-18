package chapter10;

public class CompiletimeException {
    public static void main(String[] args) throws ClassNotFoundException {
        // 예외를 직접 처리
        // try catch

        // 예외를 처리하지 않고 떠넘겨줌
        Class.forName("javaj.lang.String");

    }
}
