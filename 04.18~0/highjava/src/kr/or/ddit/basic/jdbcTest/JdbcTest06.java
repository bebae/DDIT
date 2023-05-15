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
            try { if(rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if(stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if(conn != null) conn.close(); } catch (SQLException ignored) {}
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
            System.out.println("5. 원하는 항목만 수정");
            System.out.println("0. 작업 끝");
            System.out.println("----------------------");
            System.out.print("메뉴 입력 >>> ");
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
                case 5:
                    updateMember2();
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

    /**
     *  선택한 항목만 수정할 수 있게 하는 업데이트
     */
    private void updateMember2() throws SQLException {
        boolean isDuplicate = true;
        String sql="";
        String id="";
        while (isDuplicate) {
            System.out.print("회원 ID ▶ ");
            id = scan.nextLine();
            sql = "SELECT COUNT(*) FROM mymember WHERE mem_id = ?";
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
            }
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isDuplicate = false;
            } else {
                System.out.println("존재하지 않는 id 입니다. 다시 입력하세요.");
            }
        }
        System.out.println("수정 사항");
        System.out.println("----------------------");
        System.out.println(" 1. 패스워드");
        System.out.println(" 2. 회원이름");
        System.out.println(" 3. 전화번호");
        System.out.println(" 4. 주소");
        System.out.println("----------------------");
        System.out.print("수정할 항목 ▶ ");
        int menu = Integer.parseInt(scan.nextLine());
        String select = "";
        switch (menu) {
            case 1:
                select = "mem_pass";
                System.out.print("새로운 패스워드 ▶ ");
                break;
            case 2:
                select = "mem_name";
                System.out.print("새로운 회원이름 ▶ ");
                break;
            case 3:
                select = "mem_tel";
                System.out.print("새로운 전화번호 ▶ ");
                break;
            case 4:
                select = "mem_addr";
                System.out.print("새로운 주소 ▶ ");
                break;
            default:
                System.out.println("입력 실패 ㅠㅠ");
                return;
        }
        String update = scan.nextLine();

        sql = "UPDATE mymember SET " +  select + " = ? WHERE mem_id = ?";

        if (conn != null) {
            pstmt = conn.prepareStatement(sql);
        }
        pstmt.setString(1, update);
        pstmt.setString(2, id);
        int cnt = pstmt.executeUpdate();

        if (cnt > 0) {
            System.out.println("UPDATE ㄱㄱ 되었습니다.");
        } else {
            System.out.println("UPDATE ㄱㄱ가  ㅠㅠ");
        }

    }

    public void insertMember() throws SQLException {
        boolean isDuplicate = true;
        String sql="";
        String id="";
        while (isDuplicate) {
            System.out.print("회원 ID ▶");
            id = scan.nextLine();
            sql = "SELECT COUNT(*) FROM mymember WHERE mem_id = ?";
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
            }
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                isDuplicate = false;
            } else {
                System.out.println("이미 존재하는 id 입니다. 다시 입력하세요.");
            }
        }

        System.out.print("패스워드 ▶ ");
        String pass = scan.nextLine();
        System.out.print("이름  ▶ ");
        String name = scan.nextLine();
        System.out.print("주소  ▶ ");
        String addr = scan.nextLine();
        System.out.print("전화번호  ▶ ");
        String phone = scan.nextLine();


        sql = "INSERT INTO mymember(mem_id, mem_pass, mem_name, mem_addr, mem_tel) " +
                "VALUES(?, ?, ?, ?, ?)";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        pstmt.setString(3, name);
        pstmt.setString(4, addr);
        pstmt.setString(5, phone);
        int cnt = pstmt.executeUpdate();
        if (cnt > 0) {
            System.out.println("insert ㄱㄱ 되었습니다.");
        } else {
            System.out.println("insert ㄱㄱ가  ㅠㅠ");
        }
    }

    public void deleteMember() throws SQLException {
        System.out.print("지울 ID를 입력해주세요 ▶");
        String id = scan.nextLine();

        String sql = "DELETE FROM mymember WHERE mem_id = ?";
        if (conn != null) {
            pstmt = conn.prepareStatement(sql);
        }
        pstmt.setString(1, id);
        int cnt = pstmt.executeUpdate();

        if (cnt > 0) {
            System.out.println("delete ㄱㄱ 되었습니다.");
        } else {
            System.out.println("delete ㄱㄱ가  ㅠㅠ");
        }
    }

    public void updateMember() throws SQLException {
        System.out.print("수정할 ID ▶");
        String id = scan.nextLine();
        System.out.print("새로운 이름 ▶");
        String name = scan.nextLine();
        System.out.print("새로운 주소  ▶");
        String addr = scan.nextLine();
        System.out.print("새로운 전화번호 ▶");
        String phone = scan.nextLine();

        String sql = "UPDATE mymember SET mem_name = ?, mem_addr = ?, mem_tel = ? WHERE mem_id = ?";
        if (conn != null) {
            pstmt = conn.prepareStatement(sql);
        }
        pstmt.setString(1, name);
        pstmt.setString(2, addr);
        pstmt.setString(3, phone);
        pstmt.setString(4, id);
        int cnt = pstmt.executeUpdate();

        if (cnt > 0) {
            System.out.println("UPDATE ㄱㄱ 되었습니다.");
        } else {
            System.out.println("UPDATE ㄱㄱ가  ㅠㅠ");
        }
    }

    public void selectMember() throws SQLException {
        String sql = "SELECT mem_id, mem_name, mem_addr, mem_tel FROM mymember";
        if (conn != null)
            stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("mem_id");
            String name = rs.getString("mem_name");
            String addr = rs.getString("mem_addr");
            String phone = rs.getString("mem_tel");
            System.out.println(id + "\t" + name + "\t" + addr + "\t" + phone);
        }
    }
}
