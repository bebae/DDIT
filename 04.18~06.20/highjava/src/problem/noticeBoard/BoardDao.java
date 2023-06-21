package problem.noticeBoard;

import kr.or.ddit.util.DBUtil3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao implements BoardDaoInterface {
    // Singleton 패턴 구현
    private static BoardDao instance;

    private BoardDao() {
        // 생성자를 private로 선언하여 외부에서의 인스턴스 생성을 제한
    }

    public static BoardDao getInstance() {
        if (instance == null) instance = new BoardDao();
        return instance;
    }

    @Override
    public List<BoardVo> getBoardList() {
        List<BoardVo> boardVoList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (전체 목록 조회)
            String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                // ResultSet으로부터 데이터 추출하여 BoardDTO 객체에 설정
                BoardVo boardVo = new BoardVo(
                        rs.getInt("board_no"),
                        rs.getString("board_title"),
                        rs.getString("board_writer"),
                        rs.getDate("board_date"),
                        rs.getInt("board_cnt")
                );

                boardVoList.add(boardVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }

        return boardVoList;
    }

    @Override
    public int insertBoard(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (새글 작성)
            String sql = "INSERT INTO jdbc_board (board_no, board_title, board_writer, board_date, board_content) " +
                    "VALUES (board_seq.nextVal, ?, ?, sysdate, ?)";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVo.getBoardTitle());
            pstmt.setString(2, boardVo.getBoardWriter());
            pstmt.setString(3, boardVo.getBoardContent());

            cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("새글이 추가되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }
        return cnt;
    }


    @Override
    public int updateBoard(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (게시물 수정)
            String sql = "UPDATE jdbc_board SET board_title = ?, board_content = ? WHERE board_no = ?";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVo.getBoardTitle());
            pstmt.setString(2, boardVo.getBoardContent());
            pstmt.setInt(3, boardVo.getBoardNo());

            cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("게시물이 수정되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
        return cnt;
    }

    @Override
    public int deleteBoard(int boardNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (게시물 삭제)
            String sql = "DELETE FROM jdbc_board WHERE board_no = ?";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);

            cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("게시물이 삭제되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
        return cnt;
    }

    @Override
    public BoardVo getBoardByNo(int boardNo) {
        BoardVo boardVo = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL statement to retrieve board by board number
            String sql = "SELECT * FROM jdbc_board WHERE board_no = ?";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            rs = pstmt.executeQuery();

            // 결과 처리
            if (rs.next()) {
                // ResultSet에서 데이터를 추출하고 생성자를 사용하여 새 BoardVo 개체를 만듭니다.
                boardVo = new BoardVo(
                        rs.getInt("board_no"),
                        rs.getString("board_title"),
                        rs.getString("board_writer"),
                        rs.getDate("board_date"),
                        rs.getInt("board_cnt"),
                        rs.getString("board_content")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }
        return boardVo;
    }

    @Override
    public List<BoardVo> searchBoard(String title) {
        List<BoardVo> boardVoList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (제목으로 검색)
            String sql = "SELECT * FROM jdbc_board WHERE board_title LIKE ?";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                // ResultSet으로부터 데이터 추출하여 BoardDTO 객체에 설정
                BoardVo boardVo = new BoardVo();
                boardVo.setBoardNo(rs.getInt("board_no"));
                boardVo.setBoardTitle(rs.getString("board_title"));
                boardVo.setBoardWriter(rs.getString("board_writer"));
                boardVo.setBoardDate(rs.getDate("board_date"));
                boardVo.setBoardCnt(rs.getInt("board_cnt"));
                boardVoList.add(boardVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }

        return boardVoList;
    }

    @Override
    public int increaseBoardCount(int boardNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;
        try {
            conn = DBUtil3.getConnection();

            // SQL statement to increase board count
            String sql = "UPDATE jdbc_board SET board_cnt = board_cnt + 1 WHERE board_no = ?";

            assert conn != null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
        return cnt;
    }
}

