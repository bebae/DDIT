package problem.noticeBoard;

import java.util.List;

public interface BoardDaoInterface {
    /**
     * JDBC_BOARD 테이블 전체 레코드를 가져와 List에 담아 반환하는 메소드
     *
     * @return VO객체가 담긴 List
     */
    List<BoardVo> getBoardList();

    /**
     * BoardVo에 담겨진 자료를 DB에 insert하는 메소드
     *
     * @param boardVo insert할 VO 객체
     * @return 작업성공 1, 작업실패 0
     */
    int insertBoard(BoardVo boardVo);

    /**
     * 게시판 번호를 매개변수로 해당 게시글을 삭제하는 메소드
     *
     * @param boardNo 삭제할 게시글 번호
     * @return 작업성공 1, 작업실패 0
     */
    int deleteBoard(int boardNo);

    /**
     * 수정할 정보가 저장된 VO객체를 매개변수로 받아서 수정하는 메소드
     *
     * @param boardVo 수정할 정보가 저장된 Vo 객체
     * @return 작업성공 1, 작업실패 0
     */
    int updateBoard(BoardVo boardVo);

    /**
     * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메소드
     *
     * @param boardNo 가저올 게시글 번호
     * @return 해당 게시글 번호에 맞는 VO객체 (레코드), 자료가 없으면 Null
     */
    BoardVo getBoardByNo(int boardNo);


    /**
     * JDBC_BOARD 테이블에서 검색한 결과를 List에 담아 반환하는 메소드
     *
     * @param title 검색할 게시글 제목
     * @return 검색된 결과가 저장된 Vo객체 List를 반환
     */
    List<BoardVo> searchBoard(String title);

    /**
     * 게시글 번호를 매개변수로 받아 해당 게시글의 조회수를 증가시키는 메소드
     *
     * @param boardNo 조회수를 올릴 게시글
     * @return 작업성공 1, 작업실패 0
     */
    int increaseBoardCount(int boardNo);
}
