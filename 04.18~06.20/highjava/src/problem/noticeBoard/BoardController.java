package problem.noticeBoard;

import java.util.List;

public class BoardController {
    private static BoardController instance;
    private final BoardService boardService;
    private final BoardView boardView;

    private BoardController() {
        boardService = BoardService.getInstance();
        boardView = BoardView.getInstance();
    }

    public static BoardController getInstance() {
        if (instance == null) instance = new BoardController();
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


    private void viewBoardDetail() {
        int boardNo = boardView.getInputForBoardView();
        BoardVo boardVo = boardService.getBoardByNo(boardNo);
        int result = boardService.increaseBoardCount(boardNo);
        if (result == 0) {
            boardView.showMessage("조회수 수정에  실패했습니다.");
        }
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

    private void createNewBoard() {
        BoardVo newBoardVo = boardView.getNewBoardInfo();
        int result = boardService.insertBoard(newBoardVo);
        if (result == 1) {
            boardView.showMessage("새 글이 추가되었습니다.");
        } else {
            boardView.showMessage("글 추가에 실패했습니다.");
        }
    }

    private void updateBoard(BoardVo boardVo) {
        BoardVo updatedBoard = boardView.getUpdatedBoardInfo(boardVo);
        int result = boardService.updateBoard(updatedBoard);
        if (result == 1) {
            boardView.showMessage("글이 수정되었습니다.");
            boardView.showBoardDetail(updatedBoard);
        } else {
            boardView.showMessage("글 수정에 실패했습니다.");
        }
    }

    private void deleteBoard(int boardNo) {
        int result = boardService.deleteBoard(boardNo);
        if (result == 1) {
            boardView.showMessage("글이 삭제되었습니다.");
        } else {
            boardView.showMessage("글 삭제에 실패했습니다.");
        }
    }


    private void searchBoard() {
        String keyword = boardView.getSearchKeyword();
        List<BoardVo> searchResults = boardService.searchBoard(keyword);
        boardView.showSearchResults(searchResults);
    }
}
