package kr.or.ddit.basic.jdbcTest;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest04 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "pc03";
        String password = "java";
        conn = DriverManager.getConnection(url, user, password);

        System.out.println("계좌번호 정보 추가하기");
        System.out.print("계좌번호 : ");
        String bankNo = scan.next();
        System.out.print("은행명 : ");
        String bankName = scan.next();
        System.out.print("예금주명 : ");
        String userName = scan.next();

//        insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)
//        values ('111-222-33-4444', '하나은행', '홍길동', sysdate);

        String sql = "INSERT INTO bankinfo (bank_no, bank_name, bank_user_name, bank_date) "
                +" VALUES (?, ?, ?, sysdate)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, bankNo);
        pstmt.setString(2, bankName);
        pstmt.setString(3, userName);
        int cnt = pstmt.executeUpdate();
        System.out.println("cnt : " + cnt);

        scan.close();
    }
}
