package kr.or.ddit.vo;

/*
    username varchar2(100),
    book_id varchar2(10),
    pur_cnt number,
    pur_dt date,
 */
public class PurInfoVO {
    private String username;
    private String bookId;
    private int purCnt;
    private String purDt;

    public PurInfoVO() {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public int getPurCnt() {
        return purCnt;
    }
    public void setPurCnt(int purCnt) {
        this.purCnt = purCnt;
    }
    public String getPurDt() {
        return purDt;
    }
    public void setPurDt(String purDt) {
        this.purDt = purDt;
    }

    @Override
    public String toString() {
        return "PurInfoVO{" + "username='" + username + '\'' +
                ", bookId='" + bookId + '\'' +
                ", purCnt=" + purCnt +
                ", purDt='" + purDt + '\'' +
                '}';
    }
}
