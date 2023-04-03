package chapter10;

public class TryCatchFinallyRuntimeExceptionExample {
    public static void main(String[] args) {
        String data1;
        String data2;

        try {
            data1 = args[0];
            data2 = args[1];
//            data1 = "십";
//            data2 = "20";
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1+"+"+data2 + "="+result);
        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
            System.out.println("실행 매개값의 수가 부족합니다");
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("다시 실행하세요.");
        }


        String[] strArray = {"10","2a"};
        int value = 0;
        for (int i = 0; i <=  strArray.length; i++) {
            try {
                value = Integer.parseInt(strArray[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("인덱스 초과");
            } catch (NumberFormatException e) {
                System.err.println("숫자로 변환 불가");
            } finally {
                System.out.println(value);
            }
        }
    }
}
