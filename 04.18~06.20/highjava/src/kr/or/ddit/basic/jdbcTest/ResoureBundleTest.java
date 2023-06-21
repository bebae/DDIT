package kr.or.ddit.basic.jdbcTest;

import java.util.ResourceBundle;

/**
 *  ResourceBundle 객체 => 파일의 확장자가 'properties'인 파일의 내용을 읽어와서
 *      key값과 value값을 구분해서 정보를 갖고 있는 객체
 */
public class ResoureBundleTest {
    public static void main(String[] args) {
        // ResourceBundle 객체를 이용 -> properties 파일을 읽기
        
        // ResourceBundle 객체 생성 => properties 파일 정보를 지정('패키지명.파일명' 확장자는 입력 X, properties가 아니면 에러)
        ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");

        // 읽어온 내용 출력
        System.out.println("driver : " + bundle.getString("driver"));
        System.out.println("url : " + bundle.getString("url"));
        System.out.println("user : " + bundle.getString("user"));
        System.out.println("pass : " + bundle.getString("pass"));
    }
}
