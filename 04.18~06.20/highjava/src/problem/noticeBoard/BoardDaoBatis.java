package problem.noticeBoard;

import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoBatis implements BoardDaoInterface {
    // Singleton 패턴 구현
    private static BoardDaoBatis instance;

    private BoardDaoBatis() {
        // 생성자를 private로 선언하여 외부에서의 인스턴스 생성을 제한
    }

    public static BoardDaoBatis getInstance() {
        if (instance == null) instance = new BoardDaoBatis();
        return instance;
    }

    @Override
    public List<BoardVo> getBoardList() {
        List<BoardVo> boardVoList;
        SqlSession session = null;

        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            boardVoList = session.selectList("board.getBoardList");
        }finally {
            if(session != null) session.close();
        }

        return boardVoList;
    }

    @Override
    public int insertBoard(BoardVo boardVo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.insert("board.insertBoard", boardVo);

            if (cnt > 0) {
                System.out.println("새글이 추가되었습니다.");
            }
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }


    @Override
    public int updateBoard(BoardVo boardVo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.update("board.updateBoard", boardVo);
            if (cnt > 0) {
                System.out.println("게시물이 수정되었습니다.");
            }
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }

    @Override
    public int deleteBoard(int boardNo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();

            cnt = session.delete("board.deleteBoard", boardNo);
            if (cnt > 0) {
                System.out.println("게시물이 삭제되었습니다.");
            }
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }

    @Override
    public BoardVo getBoardByNo(int boardNo) {
        SqlSession session = null;
        BoardVo boardVo;

        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            boardVo = session.selectOne("board.getBoardByNo", boardNo);

        } finally {
            if(session != null) session.close();
        }
        return boardVo;
    }

    @Override
    public List<BoardVo> searchBoard(String title) {
        List<BoardVo> boardVoList;
        SqlSession session = null;

        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            boardVoList = session.selectList("board.searchBoard", "%"+title+"%");

        } finally {
            if(session != null) session.close();
        }

        return boardVoList;
    }

    @Override
    public int increaseBoardCount(int boardNo) {
        SqlSession session = null;
        int cnt = 0;
        try {
            session = MyBatisSqlSessionFactory.getSqlSession();
            cnt = session.update("board.increaseBoardCount", boardNo);
            if (cnt > 0) {
                System.out.println("게시글이 검색되었습니다.");
            }
        } finally {
            if(session != null) session.close();
        }
        return cnt;
    }
}

