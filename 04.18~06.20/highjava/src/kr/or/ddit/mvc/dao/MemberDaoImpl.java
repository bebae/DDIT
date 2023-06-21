package kr.or.ddit.mvc.dao;

import kr.or.ddit.mvc.vo.MemberVo;
import kr.or.ddit.util.DBUtil3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberDaoImpl implements IMemberDao {

    private static MemberDaoImpl memDao;

    private MemberDaoImpl() {}

    public static MemberDaoImpl getInstance() {
        if(memDao == null) memDao = new MemberDaoImpl();
        return memDao;
    }

    @Override
    public int insertMember(MemberVo memberVo) {
        Connection conn = DBUtil3.getConnection();
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            String sql = "insert into mymember(mem_id, mem_pass, mem_name, mem_tel, mem_addr) values(?,?,?,?,?)";
            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberVo.getMem_id());
            pstmt.setString(2, memberVo.getMem_pass());
            pstmt.setString(3, memberVo.getMem_name());
            pstmt.setString(4, memberVo.getMem_tel());
            pstmt.setString(5, memberVo.getMem_addr());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }

        return cnt;
    }

    @Override
    public int deleteMember(String memId) {
        Connection conn = DBUtil3.getConnection();
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            String sql = "delete from mymember where mem_id = ?";
            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }

        return cnt;
    }

    @Override
    public int updateMember(MemberVo memberVo) {
        Connection conn = DBUtil3.getConnection();
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberVo.getMem_name());
            pstmt.setString(2, memberVo.getMem_tel());
            pstmt.setString(3, memberVo.getMem_addr());
            pstmt.setString(4, memberVo.getMem_id());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }

        return cnt;
    }

    @Override
    public List<MemberVo> getAllMember() {
        Connection conn = DBUtil3.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<MemberVo> memberList = new ArrayList<>(); // 반환할 리스트 객체 생성
        try {
            String sql = "SELECT mem_id, mem_name, mem_addr, mem_tel FROM mymember";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("mem_id");
                String name = rs.getString("mem_name");
                String addr = rs.getString("mem_addr");
                String phone = rs.getString("mem_tel");
                MemberVo memberVo = new MemberVo(id, name, addr, phone); // MemberVo 객체 생성
                memberList.add(memberVo); // 리스트에 추가
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 객체 반환 처리
            DBUtil3.close(conn, stmt, rs);
        }
        return memberList; // 리스트 객체 반환
    }

    @Override
    public int getMemberCount(String memId) {
        Connection conn = DBUtil3.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int cnt = 0;
        try {
            String sql = "select count(*) from mymember where mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }
        return cnt;
    }

    @Override
    public int updateMember2(Map<String, String> paramMap) {
        Connection conn = DBUtil3.getConnection();
        PreparedStatement pstmt = null;
        int cnt = 0;
        // key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
        try {
            String sql = "UPDATE mymember SET " + paramMap.get("field") + " = ? WHERE mem_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  paramMap.get("data"));
            pstmt.setString(2,  paramMap.get("memid"));
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }
        return cnt;
    }

}
