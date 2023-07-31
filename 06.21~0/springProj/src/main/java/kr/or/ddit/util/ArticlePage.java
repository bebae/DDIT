package kr.or.ddit.util;

import java.util.List;

// 페이징 + 게시글 데이터
public class ArticlePage<T> {
    // 전체게시글 수
    private  int totalCount;
    // 현재 페이지 번호
    private int currentPage;
    // 전체 페이지 수
    private int totalPage;
    // 시작 페이지 번호
    private int startPage;
    // 한 화면에 보여질 행의 수
    private int size;
    // 종료 페이지 번호
    private int endPage;
    // 데이터
    private List<T> content;

    // 생성자
    public ArticlePage(int totalCount, int currentPage, int size, List<T> content) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.content = content;
        this.size = size;
        if(totalCount == 0) {
            this.totalCount = 0;
            this.startPage = 0;
            this.endPage = 0;
        } else {        // 전체 게시글 / 한 화면에 보일 수
            totalPage = this.totalCount / size;
            if(this.totalCount % size > 0) {
                totalPage++;
            }

            // startPage formula
            startPage = currentPage / 5 * 5 + 1;
            if(currentPage % 5 == 0) {
                startPage -= 5;
            }

            // endPage formula
            endPage = startPage + (5 - 1);
            if(endPage > totalPage) {
                endPage = totalPage;
            }

        }   // end if
    }

    // getter, setter
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    // data values : null
    public boolean hasNoArticle() {
        return totalCount == 0;
    }

    // data values : not null
    public boolean hasArticle() {
        return totalCount > 0;
    }

}
