package problem.noticeBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    private static BoardView boardView;

    public static BoardView getInstance() {
        if (boardView == null) boardView = new BoardView();
        return boardView;
    }

    private final Scanner scanner;

    public BoardView() {
        scanner = new Scanner(System.in);
    }

    public int showMenuAndGetInput() {
        // 게시글 목록 출력
        List<BoardVo> boardVoList = BoardService.getInstance().getAllBoards();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("-------------------------------------------------------------");
        System.out.println(" No\t\t제 목\t\t\t작성자\t조회수\t작성일");
        System.out.println("-------------------------------------------------------------");
        for (BoardVo boardVo : boardVoList) {
            System.out.printf(" %d\t\t%s\t\t%s\t%d\t%s%n", boardVo.getBoardNo(), boardVo.getBoardTitle(), boardVo.getBoardWriter(),
                    boardVo.getBoardCnt(), dateFormat.format(boardVo.getBoardDate()));
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
        System.out.print("작업선택 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public BoardVo getNewBoardInfo() {
        BoardVo boardVo = new BoardVo();

        System.out.println("새글 작성하기");
        System.out.println("-----------------------------------");
        System.out.print("- 제  목 : ");
        boardVo.setBoardTitle(scanner.nextLine());
        System.out.print("- 작성자 : ");
        boardVo.setBoardWriter(scanner.nextLine());
        System.out.print("- 내  용 : ");
        boardVo.setBoardContent(scanner.nextLine());
        boardVo.setBoardDate(new Date());

        return boardVo;
    }

    public int getInputForBoardView() {
        System.out.print("보기를 원하는 게시물 번호 입력 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showBoardDetail(BoardVo boardVo) {
        System.out.printf("%d번글 내용%n", boardVo.getBoardNo());
        System.out.println("------------------------------------------------------------");
        System.out.println("- 제  목 : " + boardVo.getBoardTitle());
        System.out.println("- 작성자 : " + boardVo.getBoardWriter());
        System.out.println("- 내  용 : " + boardVo.getBoardContent());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("- 작성일 : " + dateFormat.format(boardVo.getBoardDate()));
        System.out.println("- 조회수 : " + boardVo.getBoardCnt());
        System.out.println("------------------------------------------------------------");
    }

    public int showBoardMenuAndGetInput() {
        System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
        System.out.print("작업선택 >> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public BoardVo getUpdatedBoardInfo(BoardVo boardVo) {
        System.out.println("수정 작업하기");
        System.out.println("-----------------------------------");
        System.out.print("- 제  목 : ");
        boardVo.setBoardTitle(scanner.nextLine());
        System.out.print("- 내  용 : ");
        boardVo.setBoardContent(scanner.nextLine());
        return boardVo;
    }

    public String getSearchKeyword() {
        System.out.print("- 검색할 제목 입력 : ");
        return scanner.nextLine();
    }
    public void showSearchResults(List<BoardVo> searchResults) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(" No\t\t제 목\t\t\t작성자\t조회수");
        System.out.println("-------------------------------------------------------------");
        for (BoardVo boardVo : searchResults) {
            System.out.printf(" %d\t\t%s\t\t%s\t%d%n", boardVo.getBoardNo(), boardVo.getBoardTitle(), boardVo.getBoardWriter(),
                    boardVo.getBoardCnt());
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
