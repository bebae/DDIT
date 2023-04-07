package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        // 2. DB 정보
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc03","java");
        // 3. DB에 Query를 전송할 워크시트 생성
        Statement statement = connection.createStatement();
        // 4.
//        String sql = "SELECT MEM_ID, MEM_NAME, MEM_HP, MEM_MAIL FROM MEMBER";
//        sql += " SELECT";
//        sql += "    mem_id,";
//        sql += "    mem_name,";
//        sql += "    mem_hp,";
//        sql += "    mem_mail";
//        sql += " FROM";
        // 문자열 concatenation(결합) : StringBuilder VS StringBuffer
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append("    mem_id,");
        sb.append("    mem_name,");
        sb.append("    mem_hp,");
        sb.append("    mem_mail ");
        sb.append("FROM");
        sb.append("    member");
        String sql = sb.toString();

        // 5.
        ResultSet resultSet = statement.executeQuery(sql);    // select
//        statement.executeUpdate(sql);   // insert/update/delete

        List<String[]> results = new ArrayList<>();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columCount = rsmd.getColumnCount();

        // 6.
        while (resultSet.next()) {
            /*
            String mamId = resultSet.getString("mem_id");
            String memName = resultSet.getString("mem_name");
            String memHp = resultSet.getString("mem_hp");
            String memMail = resultSet.getString("mem_mail");
            System.out.printf("%s\t%s\t%s\t%s\n",mamId,memName,memHp,memMail);
             */
            String[] row = new String[columCount];
            for (int i = 1; i <= columCount; i++) {
                row[i-1] = resultSet.getString(i);
            }
            results.add(row);
        }
        for (String[] row : results) {
            System.out.println(String.join("\t",row));
        }

        // 7.
        resultSet.close();      // 쿼리 종료
        statement.close();      // 객체 종료
        connection.close();     // 접속 종료



    }
}













