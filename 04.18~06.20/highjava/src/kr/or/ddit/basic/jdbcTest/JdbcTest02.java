package kr.or.ddit.basic.jdbcTest;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "pc03";
        String password = "java";
        conn = DriverManager.getConnection(url, user, password);

        System.out.print("lprod_id 를 입력하세요 : ");
        int where = new Scanner(System.in).nextInt();

        String sql = "select lprod_id, lprod_gu, lprod_nm from lprod " +
                "where lprod_id >= '" + where + "' " +
                "ORDER BY lprod_id ASC";

        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        int lprod_id = 0;
        String lprod_gu = "";
        String lprod_nm = "";
        while (rs.next()) {
            lprod_id = rs.getInt("lprod_id");
            lprod_gu = rs.getString("lprod_gu");
            lprod_nm = rs.getString("lprod_nm");
            System.out.printf("%2d %s %s\n", lprod_id, lprod_gu, lprod_nm);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
