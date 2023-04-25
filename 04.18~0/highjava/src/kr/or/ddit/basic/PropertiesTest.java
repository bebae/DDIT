package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {
    /*

     *  Properties 객체는 Map 보다 축소된 기능의 객체라고 할 수 있다.
        Map 객체는 key 값과 value 값에 모든 형태의 객체를 사용할 수 있지만,
        Properties 객체는 key 값과 value 값에 String 만 사용할 수 있다.
        주로 프로그램의 환경설정에 필요한 정보를 관리하는 용도로 사용된다.

        Properties 객체는 setProperty(), getProperty() 메소드를 이용해서 데이터를 입출력한다.
     */
    public static void main(String[] args) {
        Properties props = new Properties();

        // 데이터 저장
        props.setProperty("name", "John");
        props.setProperty("age", String.valueOf(20));
        props.setProperty("tel", "010-1234-5678");
        props.setProperty("addr", "대전 중구 오류동");

        String name  = props.getProperty("name");
        int tempAge = Integer.parseInt(props.getProperty("age"));
        String tel = props.getProperty("tel");
        String addr = props.getProperty("addr");

        System.out.println("name : " + name);
        System.out.println("age : " + tempAge);
        System.out.println("tel : " + tel);
        System.out.println("addr : " + addr);

    }
}
