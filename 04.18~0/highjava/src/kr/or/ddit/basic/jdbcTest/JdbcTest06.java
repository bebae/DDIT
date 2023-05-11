package kr.or.ddit.basic.jdbcTest;

import kr.or.ddit.util.DBUtil;

import java.sql.*;
import java.util.Scanner;

/*
    회원 관리 프로그램 작성
    아래 메뉴의 기능을 모두 구형하시오. (CRUD 기능)
    메뉴예시)
    ----------------------
    1. 자료 추가            ---> insert (C)
    2. 자료 삭제            ---> delete (D)
    3. 자료 수정            ---> update (U)
    4. 전체 자료 출력       ---> select (R)
    0. 작업 끝              ---> exit
    ----------------------

    조건)
    1) '자료 추가' 메뉴에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받기)
    2) 자료 삭제는 '회원ID'를 입력 받아 처리
    3) 자료 수정에서 '회원ID'는 변경되지 않는다.


 */
public class JdbcTest06 {

    private final Scanner scan = new Scanner(System.in);
    private final Connection conn = DBUtil.getConnection();
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    public static void main(String[] args) {
        JdbcTest06 test = new JdbcTest06();
        test.start();

    }

    public void start() {
        try {
            menuPrint();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try { rs.close(); } catch (SQLException ignored) {}
            try { stmt.close(); } catch (SQLException ignored) {}
            try { conn.close(); } catch (SQLException ignored) {}
        }
    }

    public void menuPrint() throws SQLException {
        Scanner scan = new Scanner(System.in);
        int menu = -1;
        while (true) {
            System.out.println("----------------------");
            System.out.println("1. 자료 추가");
            System.out.println("2. 자료 삭제");
            System.out.println("3. 자료 수정");
            System.out.println("4. 전체 자료 출력");
            System.out.println("0. 작업 끝");
            System.out.println("----------------------");
            System.out.print("메뉴 입력 >>>");
            menu = scan.nextInt();
            switch (menu) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    selectMember();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다. ㅠㅠ");
                    System.exit(0);
                    return;
                default:
                    System.out.println("잘못된 입력입니다. ㅠㅠ");
                    break;
            }
        }
    }

    public void insertMember() throws SQLException {
        boolean isDuplicate = true;
        String sql="";
        String id="";
        while (isDuplicate) {
            System.out.print("회원 ID ▶");
            id = scan.next();
            sql = "SELECT COUNT(*) FROM mymember WHERE mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                isDuplicate = false;
            } else {
                System.out.println("이미 존재하는 id 입니다. 다시 입력하세요.");
            }
        }


        System.out.print("이름  ▶");
        String name = scan.next();
        System.out.print("주소  ▶");
        String addr = scan.next();
        System.out.print("전화번호  ▶");
        String phone = scan.next();


        sql = "INSERT INTO mymember(mem_id, mem_name, mem_addr, mem_tel) " +
                "VALUES(?, ?, ?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, addr);
        pstmt.setString(3, phone);
        int cnt = pstmt.executeUpdate();
        if (cnt > 0) {
            System.out.println("insert ㄱㄱ 되었습니다.");
        } else {
            System.out.println("insert ㄱㄱ가  ㅠㅠ");
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void deleteMember() throws SQLException {
        System.out.print("지울 ID를 입력해주세요 ▶");
        String id = scan.next();

        String sql = "DELETE FROM mymember WHERE mem_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        int cnt = pstmt.executeUpdate();

        if (cnt > 0) {
            System.out.println("delete ㄱㄱ 되었습니다.");
        } else {
            System.out.println("delete ㄱㄱ가  ㅠㅠ");
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void updateMember() throws SQLException {
        System.out.print("수정할 ID ▶");
        String id = scan.next();
        System.out.print("수정된 이름 ▶");
        String name = scan.next();
        System.out.print("수정된 주소  ▶");
        String addr = scan.next();
        System.out.print("수정된 전화번호 ▶");
        String phone = scan.next();

        String sql = "UPDATE mymember SET mem_name = ?, mem_addr = ?, mem_tel = ? WHERE mem_id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, addr);
        pstmt.setString(3, phone);
        pstmt.setString(4, id);
        int cnt = pstmt.executeUpdate();

        if (cnt > 0) {
            System.out.println("delete ㄱㄱ 되었습니다.");
        } else {
            System.out.println("delete ㄱㄱ가  ㅠㅠ");
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void selectMember() throws SQLException {
        String sql = "SELECT mem_id, mem_name, mem_addr, mem_tel FROM mymember";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("mem_id");
            String name = rs.getString("mem_name");
            String addr = rs.getString("mem_addr");
            String phone = rs.getString("mem_tel");
            System.out.println(id + "\t" + name + "\t" + addr + "\t" + phone);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
