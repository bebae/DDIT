package kr.or.ddit.controller;

import kr.or.ddit.service.BookInfoService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.vo.BookInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class BookInfoController {

    @Autowired
    BookInfoService  bookInfoService;

    @GetMapping("/bookInfo/addBook")
    public ModelAndView addBook(ModelAndView mav) {
        mav.setViewName("bookInfo/addBook");
        return mav;
    }

    /*
    요청URL : /bookInfo/addBookPost
    요청파라미터 : {bookId=A0001, name="세이노의 가르침" ...}
    요청 방식 : POST
     */
    @PostMapping("/bookInfo/addBookPost")
    public ModelAndView addBookPost(ModelAndView mav, @ModelAttribute BookInfoVO bookInfoVO) {
        log.info("bookInfoVo : " + bookInfoVO);

        int result = this.bookInfoService.addBookPost(bookInfoVO);
        log.info("addBookPost -> result : " + result);

        // 세부정보로 이동
        mav.setViewName("bookInfo/detailBook");
        return mav;
    }

    @ResponseBody
    @PostMapping("/bookInfo/getBookId")
    public String getBookId() {
        return this.bookInfoService.getBookId();
    }

    // 도서 목록
    @GetMapping("/bookInfo/listBook")
    public ModelAndView listBook(ModelAndView mav,
         @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage, @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("currentPage", currentPage);
        map.put("size", size);


        List<BookInfoVO> data = this.bookInfoService.listBook(map);
        log.info("도서 목록 data : " + data);
        int total = this.bookInfoService.getBookInfoTotal();
        log.info("total : " + total);

        // data를 페이징 처리해서 넣기
        mav.addObject("data", new ArticlePage<BookInfoVO>(total, currentPage, size, data));

        mav.setViewName("bookInfo/listBook");
        return mav;
    }

}
