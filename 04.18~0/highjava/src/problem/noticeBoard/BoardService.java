package problem.noticeBoard;

import java.util.List;

public class BoardService {
    private static BoardService instance;
    private final BoardDao boardDao;

    private BoardService() {
        boardDao = BoardDao.getInstance();
    }

    public static BoardService getInstance() {
        if (instance == null) {
            instance = new BoardService();
        }
        return instance;
    }

    // 전체 목록 출력
    public List<BoardVo> getAllBoards() {
        return boardDao.getBoardList();
    }

    // 새글 작성
    public void insertBoard(BoardVo boardVo) {
        boardDao.insertBoard(boardVo);
    }


    // 게시글 보기
    public BoardVo getBoardByNo(int boardNo) {
        return boardDao.getBoardByNo(boardNo);
    }

    // 게시글 수정
    public void updateBoard(BoardVo boardVo) {
        boardDao.updateBoard(boardVo);
    }

    // 게시글 삭제
    public void deleteBoard(int boardNo) {
        boardDao.deleteBoard(boardNo);
    }

    // 게시글 검색
    public List<BoardVo> searchBoard(String title) {
        return boardDao.searchBoard(title);
    }
}

