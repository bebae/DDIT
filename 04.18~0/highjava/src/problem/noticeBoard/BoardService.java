package problem.noticeBoard;

import java.util.List;

public class BoardService {
    private static BoardService instance;
    private final BoardDao boardDao;

    private BoardService() {
        boardDao = BoardDao.getInstance();
    }

    public static BoardService getInstance() {
        if (instance == null) instance = new BoardService();
        return instance;
    }

    // 전체 목록 출력
    public List<BoardVo> getAllBoards() {
        return boardDao.getBoardList();
    }

    // 새글 작성
    public int insertBoard(BoardVo boardVo) {
        return boardDao.insertBoard(boardVo);
    }


    // 게시글 보기
    public BoardVo getBoardByNo(int boardNo) {
        return boardDao.getBoardByNo(boardNo);
    }

    // 게시글 수정
    public int updateBoard(BoardVo boardVo) {
        return boardDao.updateBoard(boardVo);
    }

    // 게시글 삭제
    public int deleteBoard(int boardNo) {
        return boardDao.deleteBoard(boardNo);
    }

    // 게시글 검색
    public List<BoardVo> searchBoard(String title) {
        return boardDao.searchBoard(title);
    }

    public int increaseBoardCount(int boardNo) {
        return boardDao.increaseBoardCount(boardNo);
    }
}

