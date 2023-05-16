package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  JDBC 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메소드로 구성된 class
 */
public class DBUtil2 {
    private static final Properties prop;    // 프로퍼티 객체 변수 선언

    static {
        prop = new Properties();
        File file = new File("./res/kr/or/ddit/config/dbinfo.properties");

        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);

//            Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName(prop.getProperty("driver"));
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ㅠㅠ");
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        try {
//            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "pc03", "java");
            return DriverManager.getConnection(
                    prop.getProperty("url"),
                    prop.getProperty("user"),
                    prop.getProperty("pass")
            );
        } catch (SQLException e) {
            System.out.println("DB 연결 실패 ㅠㅠ");
            return null;
        }
    }
}
