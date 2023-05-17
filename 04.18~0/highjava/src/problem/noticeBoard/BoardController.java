package problem.noticeBoard;

import java.util.List;
import java.util.Scanner;

public class BoardController {
    private static BoardController instance;
    private final BoardService boardService;
    private final BoardView boardView;
    private final Scanner scanner;

    private BoardController() {
        boardService = BoardService.getInstance();
        boardView = BoardView.getInstance();
        scanner = new Scanner(System.in);
    }

    public static BoardController getInstance() {
        if (instance == null) {
            instance = new BoardController();
        }
        return instance;
    }

    public void run() {
        int menu;
        while (true) {
            menu = boardView.showMenuAndGetInput();
            switch (menu) {
                case 1:
                    createNewBoard();
                    break;
                case 2:
                    viewBoardDetail();
                    break;
                case 3:
                    searchBoard();
                    break;
                case 0:
                    System.out.println("게시판 프로그램 종료....");
                    return;
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 선택해주세요.");
            }
        }
    }

    private void createNewBoard() {
        BoardVo newBoardVo = boardView.getNewBoardInfo();
        boardService.insertBoard(newBoardVo);
        boardView.showMessage("새글이 추가되었습니다.");
    }

    private void viewBoardDetail() {
        int boardNo = boardView.getInputForBoardView();
        BoardVo boardVo = boardService.getBoardByNo(boardNo);
        if (boardVo != null) {
            boardView.showBoardDetail(boardVo);
            handleBoardMenu(boardVo);
        } else {
            boardView.showMessage("해당 게시물을 찾을 수 없습니다.");
        }
    }

    private void handleBoardMenu(BoardVo boardVo) {
        int menu;
        while (true) {
            menu = boardView.showBoardMenuAndGetInput();
            switch (menu) {
                case 1:
                    updateBoard(boardVo);
                    break;
                case 2:
                    deleteBoard(boardVo.getBoardNo());
                    return;
                case 3:
                    return;
                default:
                    System.out.println("유효하지 않은 메뉴입니다. 다시 선택해주세요.");
            }
        }
    }

    private void updateBoard(BoardVo boardVo) {
        BoardVo updatedBoard = boardView.getUpdatedBoardInfo(boardVo);
        boardService.updateBoard(updatedBoard);
        boardView.showMessage("글이 수정되었습니다.");
        boardView.showBoardDetail(updatedBoard);
    }

    private void deleteBoard(int boardNo) {
        boardService.deleteBoard(boardNo);
        boardView.showMessage("글이 삭제되었습니다.");
    }

    private void searchBoard() {
        String keyword = boardView.getSearchKeyword();
        List<BoardVo> searchResults = boardService.searchBoard(keyword);
        boardView.showSearchResults(searchResults);
    }
}
