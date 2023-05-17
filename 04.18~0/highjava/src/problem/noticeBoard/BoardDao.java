package problem.noticeBoard;

import kr.or.ddit.util.DBUtil3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    // Singleton 패턴 구현
    private static BoardDao instance;

    private BoardDao() {
        // 생성자를 private로 선언하여 외부에서의 인스턴스 생성을 제한
    }

    public static BoardDao getInstance() {
        if (instance == null) {
            instance = new BoardDao();
        }
        return instance;
    }

    public List<BoardVo> getBoardList() {
        List<BoardVo> boardVoList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (전체 목록 조회)
            String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";

            pstmt = conn.prepareStatement(sql);
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

    public void insertBoard(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (새글 작성)
            String sql = "INSERT INTO jdbc_board (board_no, board_title, board_writer, board_date, board_content) " +
                    "VALUES (board_seq.nextVal, ?, ?, sysdate, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVo.getBoardTitle());
            pstmt.setString(2, boardVo.getBoardWriter());
            pstmt.setString(3, boardVo.getBoardContent());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("새글이 추가되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt);
        }
    }

    public BoardVo getBoardByNo(int boardNo) {
        BoardVo boardVo = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (게시물 번호로 조회)
            String sql = "SELECT * FROM jdbc_board WHERE board_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            rs = pstmt.executeQuery();

            // 결과 처리
            if (rs.next()) {
                // ResultSet으로부터 데이터 추출하여 BoardDTO 객체에 설정
                boardVo = new BoardVo();
                boardVo.setBoardNo(rs.getInt("board_no"));
                boardVo.setBoardTitle(rs.getString("board_title"));
                boardVo.setBoardWriter(rs.getString("board_writer"));
                boardVo.setBoardDate(rs.getDate("board_date"));
                boardVo.setBoardCnt(rs.getInt("board_cnt"));
                boardVo.setBoardContent(rs.getString("board_content"));

                // 조회수 증가 처리
                increaseBoardCount(boardNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }

        return boardVo;
    }

    private void increaseBoardCount(int boardNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (조회수 증가)
            String sql = "UPDATE jdbc_board SET board_cnt = board_cnt + 1 WHERE board_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
    }

    public void updateBoard(BoardVo boardVo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (게시물 수정)
            String sql = "UPDATE jdbc_board SET board_title = ?, board_content = ? WHERE board_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardVo.getBoardTitle());
            pstmt.setString(2, boardVo.getBoardContent());
            pstmt.setInt(3, boardVo.getBoardNo());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("게시물이 수정되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
    }

    public void deleteBoard(int boardNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (게시물 삭제)
            String sql = "DELETE FROM jdbc_board WHERE board_no = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("게시물이 삭제되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, null);
        }
    }

    public List<BoardVo> searchBoard(String title) {
        List<BoardVo> boardVoList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (제목으로 검색)
            String sql = "SELECT * FROM jdbc_board WHERE board_title LIKE ?";

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

    public List<BoardVo> getAllBoards() {
        List<BoardVo> boardVoList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();

            // SQL 문장 작성 (전체 게시판 조회)
            String sql = "SELECT * FROM jdbc_board ORDER BY board_no DESC";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                // ResultSet으로부터 데이터 추출하여 BoardVo 객체에 설정
                BoardVo boardVo = new BoardVo();
                boardVo.setBoardNo(rs.getInt("board_no"));
                boardVo.setBoardTitle(rs.getString("board_title"));
                boardVo.setBoardWriter(rs.getString("board_writer"));
                boardVo.setBoardDate(rs.getDate("board_date"));
                boardVo.setBoardCnt(rs.getInt("board_cnt"));
                boardVo.setBoardContent(rs.getString("board_content"));

                boardVoList.add(boardVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil3.close(conn, pstmt, rs);
        }

        return boardVoList;
    }


}

