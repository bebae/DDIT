package kr.or.ddit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/* Controller 어노테이션
 스프링 프레임워크에게 "이 클래스는 웹 브라우저의 요청(request)를
 받아들이는 컨트롤러야"라고 알려주는 것임
 스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
 이 클래스를 자바빈 객체로 등록(메모리에 바인딩)
 */
@Slf4j
@Controller
public class BookController {
	
	//DI, IoC
	@Autowired
	BookService bookService;
	
	/*
	 요청URL : /create
	 요청파라미터 : 없음
	 요청방식 : get 
	 */
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView create() {
		/*
		 ModelAndView
		 1) Model : Controller가 반환할 데이터(String, int, List, Map, VO..)를 담당
		 2) View : 화면을 담당(뷰(View : JSP)의 경로)
		 */
		ModelAndView mav = new ModelAndView();
		
		//forwarding : JSP를 처리, 컴파일하여 HTML로 만들어 리턴
		//prefix : /WEB-INF/views/
		mav.setViewName("book/create");
		//suffix : .jsp
		//조립되면 : /WEB-INF/views/book/create.jsp
		
		return mav;
	}
	
	/*
	 요청URL : /create
 	 요청파라미터 : {title=개똥이의 모험,category=소설,price=10000}
 	 요청방식 : post
 	 
 	 BookVO [bookId=0, title=개똥이의 모험, category=소설, price=10000
 	 		, content=null, insertDate=null]
	 */
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(HttpServletRequest request
			, ModelAndView mav, BookVO bookVO) {
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		
		//title : 개똥이의 모험, category : 소설price : 10000
		log.info("title : " + title + ", category : " + category + 
				 ", price : " + price);
		//bookVO : BookVO [bookId=0, title=개똥이의 모험, category=소설, price=10000, content=null
		//, insertDate=null]
		log.info("bookVO : " + bookVO);
		
		int result = this.bookService.insert(bookVO);
		log.info("result : " + result);
		
		//forwarding
		mav.setViewName("book/create");
		
		return mav;
	}
	
	//책 상세보기
	//요청URI : /detail?bookId=1
	//요청URL : /detail
	//요청파라미터 : bookId=1
	//BookVO [bookId=1, title=null, category=null, price=0
	// , content=null, insertDate=null]
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public ModelAndView detail(BookVO bookVO, ModelAndView mav) {
		log.info("detail->bookVO : " + bookVO);
		
		bookVO = this.bookService.detail(bookVO);
		//detail->bookVO(후) : BookVO [bookId=1, title=검은태양, category=드라마, price=10000,
		//content=태양은 검은가?, insertDate=Wed Jul 19 16:27:28 KST 2023]
		log.info("detail->bookVO(후) : " + bookVO);

		mav.addObject("data", bookVO);
		mav.setViewName("book/detail");
		
		return mav;
	}

	// 도서 목록
	/**
	 * 요청URI : /list?keyword="단어"
	 * @method : GET
	 * @return mav
	 *
	 * VO 에는 @ModelAttribute 단일매개변수에는 @RequestParam
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav, @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword){

		List<BookVO> list = bookService.list(keyword);

		log.info("list -> list : " + list);

		mav.addObject("list", list);
		mav.setViewName("book/list");
        return mav;
	}


	// 도서 수정
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public ModelAndView update(BookVO bookVO, ModelAndView mav){
		int result = bookService.updatePost(bookVO);

        log.info("update -> result : " + result);

		// update 성공 시 -> 책 상세 페이지로 이동
		if (result > 0) {
			mav.setViewName("redirect:/detail?bookId=" + bookVO.getBookId());
		} else {
			mav.setViewName("redirect:/list");
		}
        return mav;
	}

	// 도서 삭제
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public ModelAndView delete(BookVO bookVO, ModelAndView mav){
		int result = bookService.deletePost(bookVO);

        log.info("delete -> result : " + result);

		if (result > 0) {
			mav.setViewName("redirect:/list");
		} else {
		 	mav.setViewName("redirect:/detail?bookId=" + bookVO.getBookId());
        }
        return mav;
	}

}










