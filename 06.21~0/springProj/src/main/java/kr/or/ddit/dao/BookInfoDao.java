package kr.or.ddit.dao;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class BookInfoDao {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    // 도서 등록
    public int addBookPost(BookInfoVO bookInfoVO){

        return this.sqlSessionTemplate.insert("bookInfo.addBookPost", bookInfoVO);
    }

    // 도서등록에 첨부 파일
    public int addAttach(AttachVO attachVO){

        return this.sqlSessionTemplate.insert("bookInfo.addAttach", attachVO);
    }

    // 도서 코드 생성
    public String getBookId(){
        return this.sqlSessionTemplate.selectOne("bookInfo.getBookId");
    }

    // 도서목록
    // <resultMap> 이 포함되어 있음 하나의 도서에 여러개의 첨부파일이 있을 경우 사용함
    public List<BookInfoVO> listBook(Map<String, Object> map) {
        return this.sqlSessionTemplate.selectList("bookInfo.listBook", map);
    }

    public int getBookInfoTotal(Map<String, Object> map) {
        return this.sqlSessionTemplate.selectOne("bookInfo.getBookInfoTotal", map);
    }

    public BookInfoVO detailBook(String bookId) {
        return this.sqlSessionTemplate.selectOne("bookInfo.detailBook", bookId);
    }

    public int updateBookPost(BookInfoVO bookInfoVO) {
        return this.sqlSessionTemplate.update("bookInfo.updateBookPost", bookInfoVO);
    }

    public int updateAttach(AttachVO attachVO) {
        return this.sqlSessionTemplate.update("bookInfo.updateAttach", attachVO);
    }

    public int deleteBookPost(BookInfoVO bookInfoVO) {
        return this.sqlSessionTemplate.delete("bookInfo.deleteBookPost", bookInfoVO);
    }
}
