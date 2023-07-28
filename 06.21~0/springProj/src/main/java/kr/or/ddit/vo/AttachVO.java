package kr.or.ddit.vo;


/*
    seq NUMBER,
    book_id varchar2(10),
    filename VARCHAR2(1000),
 */
public class AttachVO {
    private int seq;
    private String bookId;
    private String filename;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "AttachVO{" +
                "seq=" + seq +
                ", bookId='" + bookId + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
