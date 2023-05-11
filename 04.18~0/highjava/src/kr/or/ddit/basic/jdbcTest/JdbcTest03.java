package kr.or.ddit.basic.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest03 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        System.out.print("첫번째 lprod_id 값 입력하세요 : ");
        int id1 = Integer.parseInt(scan.nextLine());
        System.out.print("두번째 lprod_id 값 입력하세요 : ");
        int id2 = Integer.parseInt(scan.nextLine());

        int min = Math.min(id1, id2);
        int max = Math.max(id1, id2);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "pc03";
        String password = "java";
        conn = DriverManager.getConnection(url, user, password);

        String sql = "SELECT lprod_id, lprod_gu, lprod_nm FROM lprod " +
                "WHERE lprod_id BETWEEN " + min + " AND " + max +
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
