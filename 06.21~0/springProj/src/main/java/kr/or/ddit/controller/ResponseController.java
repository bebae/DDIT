package kr.or.ddit.controller;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/resp")
@Controller
public class ResponseController {

    @Autowired
    BookService  bookService;

    @GetMapping("/goHome0101")
    public void home0101() {
        log.info("home0101");
    }

    @GetMapping("/goHome0102")
    public String home0102() {
        log.info("home0102");
        return "resp/goHome0101";
    }

    @GetMapping("/goHome0103")
    public String home0103() {
        log.info("home0103");
        return "resp/goHome0102";
    }

    @GetMapping("/goHome0203")
    public String home0203() {
        log.info("home0203");
        return "resp/goHome0203";
    }

    @GetMapping("/goHome0302")
    public String home0302() {
        log.info("goHome0302");
        return "redirect:/resp/goHome0302";
    }

//    @GetMapping("/goHome0303")
//    public ModelAndView home0303(ModelAndView mav) {
//        log.info("home0303");
//        mav.setViewName("resp/goHome0303");
//        return mav;
//    }
    @GetMapping("/goHome0303")
    public String home0303() {
        log.info("home0303");
        return "resp/goHome0303";
    }

    // 자바 빈즈 클래스 타입
    // VO -> JSON으로 반환해보자
    @ResponseBody
    @GetMapping("/goHome030101")
    public AttachVO home030301(){
        log.info("home030301");

        AttachVO attachVO = new AttachVO();
        attachVO.setSeq(1);
        attachVO.setBookId("ISBN1234");
        attachVO.setFilename("testImg.jpg");
        return attachVO;
    }

    @ResponseBody
    @GetMapping("/goHome030302")
    public BookVO home030302(@RequestParam(value="bookId", required = false, defaultValue="1") int bookId, BookVO bookVO) {
        log.info("home030302");

        bookVO.setBookId(bookId);
        bookVO = this.bookService.detail(bookVO);

        return bookVO;
    }

    // List<BookVO> retrun
    @ResponseBody
    @GetMapping("/goHome04")
    public List<BookVO> home04(BookVO bookVO) {
        log.info("home04");

        List<BookVO> list = new ArrayList<BookVO>();

        bookVO.setBookId(1);
        BookVO bookVO1 = this.bookService.detail(bookVO);
        list.add(bookVO1);

        bookVO = new BookVO();
        bookVO.setBookId(2);
        BookVO bookVO2 = this.bookService.detail(bookVO);
        list.add(bookVO2);

        return list;
    }

    // Map<String, BookVO> return
    @ResponseBody
    @GetMapping("/goHome05")
    public Map<String, BookVO> home05(BookVO bookVO) {
        log.info("home05");

        Map<String, BookVO> map = new java.util.HashMap<String, BookVO>();

        bookVO.setBookId(1);
        BookVO bookVO1 = this.bookService.detail(bookVO);
        map.put(String.valueOf(bookVO1.getBookId()), bookVO1);

        bookVO = new BookVO();
        bookVO.setBookId(2);
        BookVO bookVO2 = this.bookService.detail(bookVO);
        map.put(String.valueOf(bookVO2.getBookId()), bookVO2);

        return map;
    }

    // ResponseEntity<List> return
    @ResponseBody
    @GetMapping("/goHome09")
    public List<String> home09() {
        log.info("home09");

        List<String> list = new ArrayList<String>();

        list.add("소설");
        list.add("IT");
        list.add("SF");
        list.add("History");
        list.add("Science");

        return list;
    }

    /*
    PathVariable : URL에서 경로 변수 값 가져옴
    RequestParam : 요청 파라미터 값을 가져옴
    RequestBody : 요청 본문 내용(JSON)을 가져옴
    RequestHeader : 요청 헤더 값을 가죠옴
    CookieValue : 쿠키 값을 가져옴
     */

    @ResponseBody
    @GetMapping("/register/{userId}/{coin}")
    public String register(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
        log.info("registerByPath-> userId=" + userId);
        log.info("registerByPath-> coin=" + coin);

        return "SUCCESS";
    }

    @ResponseBody
    @PostMapping("/register0402")
    public String register0402(String userId, int coin, @DateTimeFormat(pattern = "yyyy-MM-dd") String regDate) {
        log.info("register0402-> userId=" + userId);
        log.info("register0402-> coin=" + coin);
        log.info("register0402-> regDate=" + regDate);

        return "SUCCESS";
    }


}
