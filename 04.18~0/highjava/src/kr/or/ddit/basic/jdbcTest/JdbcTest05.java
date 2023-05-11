package kr.or.ddit.basic.jdbcTest;

import kr.or.ddit.util.DBUtil;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest05 {
    public static void main(String[] args)  throws Exception {
        Scanner scan = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = DBUtil.getConnection();

        int cnt = 0;
        String lprod_gu = "";
        String sql = "";

        sql = "SELECT NVL(MAX(lprod_id), 0) maxid FROM lprod";
        assert conn != null;
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery(sql);
        int maxNum = 0;
        while (rs.next()) {
//            maxNum = rs.getInt(1);
            maxNum = rs.getInt("maxid");
            maxNum++;
        }

        boolean isDuplicate = true;
        while (isDuplicate) {
            System.out.print("lprod_gu 값 입력하세요(P101~) : ");
            lprod_gu = scan.nextLine();

            sql = "SELECT lprod_gu FROM lprod WHERE lprod_gu='" + lprod_gu + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                isDuplicate = false;
            } else {
                System.out.println("이미 존재하는 lprod_gu 입니다. 다시 입력하세요.");
            }
        }


        System.out.print("lprod_nm 값 입력하세요(컴퓨터제품, 화장품...) : ");
        String lprod_nm = scan.nextLine();

        sql = "INSERT INTO lprod (lprod_id, lprod_gu, lprod_nm) "
                +" VALUES (?, ?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, maxNum);
        pstmt.setString(2, lprod_gu);
        pstmt.setString(3, lprod_nm);
        cnt = pstmt.executeUpdate();
        if (cnt > 0) {
            System.out.println("등록 성공!");
        } else {
            System.out.println("등록 실패!");
        }
        
        
        rs.close();
        stmt.close();
        conn.close();

    }
}
