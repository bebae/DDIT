package JDBC;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCProgrammong {
	
	public static void main(String[] args) throws Exception {
        // JDBC Programming
        // JDBC (Java DataBase Connectivity)
        /*
         * 프로그래밍 언어 - 데이터에비스
         * 준비물: 드라이버(JDBC Driver): ojdbc8.jar
         * 
         *  1. 오라클 드라이버 로딩(등록)
         *  2. DB 접속 정보(ip, oracle service id, id, password)를 통해 접속
         *  3. 접속된 DB에 query를 전송할 워크시트 생성
         *  4. query 작성
         *  5. 작성된 query를 db 서버에 전송
         *  6. 전송 결과를 받아서 처리
         *  7. 접속 종료
         */

        // 1.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 2.
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        // 3.
        connection.createStatement();
        
        
    }
}
