package kr.or.ddit.basic.jdbcTest;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest05 {
    public static void main(String[] args)  throws Exception {
        Scanner scan = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "pc03";
        String password = "java";
        conn = DriverManager.getConnection(url, user, password);

        int cnt = 0;
        String lprod_gu = "";
        String sql = "";

        while (cnt != 1){
            System.out.print("lprod_gu 값 입력하세요(P101~) : ");
            lprod_gu = scan.nextLine();

            sql = "SELECT lprod_id, lprod_gu, lprod_nm FROM lprod WHRER '"+lprod_gu+"'";

            // TODO 여기 오류
            pstmt = conn.prepareStatement(sql);
            cnt = pstmt.executeUpdate();
        }
        System.out.print("lprod_nm 값 입력하세요(컴퓨터제품, 화장품...) : ");
        String lprod_nm = scan.nextLine();
        
        sql = "SELECT MAX(lprod_id) FROM lprod";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        int lprod_id = 0;
        while (rs.next()) {
            lprod_id = rs.getInt("lprod_id");
        }
        

        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) "
                +" VALUES (?, ?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, lprod_id);
        pstmt.setString(2, lprod_gu);
        pstmt.setString(3, lprod_nm);
        cnt = pstmt.executeUpdate();
        System.out.println("cnt : " + cnt);
        
        
        rs.close();
        stmt.close();
        conn.close();

    }
}
