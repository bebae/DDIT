package Exercise.class10;

import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;

        while (true) {
            try {
                System.out.print("어떤 수로 나누시겠습니까?>>");
                num1 = Integer.parseInt(sc.nextLine());
                System.out.print("어떤 수를 나누시겠습니까?>>");
                num2 = Integer.parseInt(sc.nextLine());
                System.out.printf("%d / %d = %.2f", num1, num2, (double)num1/(double)num2);
            } catch (ArithmeticException e) {
                System.err.println("\n0으로 나눌 수 없습니다.");
                continue;
            } catch (NumberFormatException e) {
                System.err.println("\n잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }
        sc.close();
    }
}