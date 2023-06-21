package kr.or.ddit.basic.jdbcTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        // 프로퍼티 객체는 맵과 같은 구조지만 키값과 밸류값이 모두 문자열로 이루어진 객체

        // 읽어온 정보를 저장할 Properties 객체 생성
        Properties prop = new Properties();

        // 읽어올 properties파일명을 지정할 File객체 생성
        File file = new File("./res/kr/or/ddit/config/dbinfo.properties");
        FileInputStream fis = null;     // 입력용
        try {
            fis = new FileInputStream(file);    // 파일 내용을 읽어올 입력 스트림 객체 생성

            // 입력 스트림을 이용하여 파일 내용을 읽어 Properties 객에에 저장
            prop.load(fis);        // 파일 내용을 읽고 key값과 value값으로 분류 후 Properties 객체에 저장

            System.out.println("driver : " + prop.getProperty("driver"));
            System.out.println("url : " + prop.getProperty("url"));
            System.out.println("user : " + prop.getProperty("user"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) { try { fis.close(); } catch (Exception ignored) {}
            }
        }
    }
}
