package kr.or.ddit.service;


import kr.or.ddit.vo.BookInfoVO;

import java.util.List;
import java.util.Map;


public interface BookInfoService {
	public int addBookPost(BookInfoVO bookInfoVO);

	// 도서 코드 자동 생성
	public String getBookId();

	// 도서 목록
	public List<BookInfoVO> listBook(Map<String, Object> map);

	public int getBookInfoTotal();
}
