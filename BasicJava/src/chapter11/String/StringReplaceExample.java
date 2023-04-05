package chapter11.String;

public class StringReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
        String newStr = oldStr.replace("자바","JAVA");
        System.out.println(oldStr);
        System.out.println(newStr);

        double number1 = 1.1;
        double number2 = 0.1;
        if (number1+number2 == 1.2) {
            System.out.println("값이 같습니다. "+number1+number2);
        } else {
            System.out.println("값이 같지 않습니다. "+number1+number2);
        }
    }
}
