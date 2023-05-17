package problem.noticeBoard;

import java.util.List;

/**
 * 게시판 서비스 인터페이스입니다.
 */
public interface BoardServiceInterface {
    /**
     * 전체 목록을 가져옵니다.
     *
     * @return 전체 게시물 목록
     */
    List<BoardVo> getAllBoards();

    /**
     * 새로운 게시물을 작성합니다.
     *
     * @param boardVo 작성할 게시물 정보
     * @return 게시물 작성 결과 (성공: 1, 실패: 0)
     */
    int insertBoard(BoardVo boardVo);

    /**
     * 게시물 번호로 게시물을 조회합니다.
     *
     * @param boardNo 조회할 게시물 번호
     * @return 조회된 게시물 정보
     */
    BoardVo getBoardByNo(int boardNo);

    /**
     * 게시물을 수정합니다.
     *
     * @param boardVo 수정할 게시물 정보
     * @return 게시물 수정 결과 (성공: 1, 실패: 0)
     */
    int updateBoard(BoardVo boardVo);

    /**
     * 게시물을 삭제합니다.
     *
     * @param boardNo 삭제할 게시물 번호
     * @return 게시물 삭제 결과 (성공: 1, 실패: 0)
     */
    int deleteBoard(int boardNo);

    /**
     * 제목으로 게시물을 검색합니다.
     *
     * @param title 검색할 제목
     * @return 검색 결과에 해당하는 게시물 목록
     */
    List<BoardVo> searchBoard(String title);
}
