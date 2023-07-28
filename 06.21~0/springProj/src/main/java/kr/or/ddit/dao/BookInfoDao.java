package kr.or.ddit.dao;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<BookInfoVO> listBook() {
        return this.sqlSessionTemplate.selectList("bookInfo.listBook");
    }

}
