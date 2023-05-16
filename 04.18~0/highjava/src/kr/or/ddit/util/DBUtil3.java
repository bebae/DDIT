package kr.or.ddit.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 *  JDBC 드라이버를 로딩하고 Connection 객체를 생성하여 반환하는 메소드로 구성된 class
 */
public class DBUtil3 {
    private static final ResourceBundle bundle;
    static {
        try {
            bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
            Class.forName(bundle.getString("driver"));
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패");
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        try {
//            return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "pc03", "java");
            return DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("user"),
                    bundle.getString("pass")
            );
        } catch (SQLException e) {
            System.out.println("오라클 연결 실패");
            return null;
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
