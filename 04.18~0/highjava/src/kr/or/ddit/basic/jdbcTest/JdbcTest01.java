package kr.or.ddit.basic.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *  JDBC를 이용한 DB자료 처리 과정
 *  1. 드라이버 로딩 ==> 라이브러리를 사용할 수 있게 메모리에 읽어 들이는 과정
 *  Class.forName("oracle.jdbc.driver.OracleDriver");
 *      (JDBC APT버전 4이상에서는 getConnection()메소드에서 자동으로 로딩하기에 생략 가능
 *  2. DB에 접속하기 ==> 접속이 완료되면 Connection 객체가 반환된다.
 *      DriverManager.getConnection()메소드를 이용한다.
 *  3. 질의문 ==> SQL 문장을 DB로 보내서 결과를 얻어온다.
 *      (Statement 객체 또는 PreparedStatement 객체를 이용하여 작업한다.)
 *  4. 결과 처리 ==> 질의 결과를 받아서 원하는 작업을 수행
 *      1) 결과값이 'select'문일 때는 ResultSet 객체에 저장되어 반환
 *      2) 결과값이 'insert, update, delete'일 경우 처리된 결과는 '정수값'으로 반환
 */
public class JdbcTest01 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // 1. 드라이버 로딩
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. DB 연결
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "pc03";
        String password = "java";
        conn = DriverManager.getConnection(url, user, password);

        // 3. 질의

        // 3-1. SQL문 작성
        String sql = "SELECT lprod_id, lprod_gu, lprod_nm as nm FROM lprod";

        // 3-2. Statement 객체 생성 => SQL문을 DB로 전달하고 처리한 결과를 얻어오는 객체
        stmt = conn.createStatement();

        // 3-3. SQL문을 DB로 보낸 결과
        rs = stmt.executeQuery(sql);

        // 4. 결과 처리
        System.out.println("== SQL 문 처리 결과 ==");
        while (rs.next()) {
            System.out.println(rs.getInt("lprod_id") + " "
                    + rs.getString("lprod_gu") + " "
                    + rs.getString("nm"));
        }
        System.out.println("====================");

        rs.close();
        stmt.close();
        conn.close();

    }
}












