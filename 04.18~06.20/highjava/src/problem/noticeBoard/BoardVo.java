package problem.noticeBoard;

import java.util.Date;

public class BoardVo {
    private int boardNo;
    private String boardTitle;
    private String boardWriter;
    private Date boardDate;
    private int boardCnt;
    private String boardContent;

    public BoardVo() {}

    public BoardVo(int boardNo, String boardTitle, String boardWriter, java.sql.Date boardDate, int boardCnt, String boardContent) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardDate = boardDate;
        this.boardCnt = boardCnt;
        this.boardContent = boardContent;
    }

    public BoardVo(int boardNo, String boardTitle, String boardWriter, java.sql.Date boardDate, int boardCnt) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardDate = boardDate;
        this.boardCnt = boardCnt;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public Date getBoardDate() {
        return boardDate;
    }

    public void setBoardDate(Date boardDate) {
        this.boardDate = boardDate;
    }

    public int getBoardCnt() {
        return boardCnt;
    }

    public void setBoardCnt(int boardCnt) {
        this.boardCnt = boardCnt;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }
}

