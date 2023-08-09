package kr.or.ddit.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController {


    @GetMapping("/registerForm")
    public void registerForm() {
        log.info("registerForm");
    }

    @GetMapping("/modifyForm")
    public void modifyForm() {
        log.info("modifyForm");

        // board 폴더의 modify.jsp

    }

    // /board/read 요청
    @GetMapping("/read/{boardNo}")
    public String readForm(@PathVariable int boardNo) {
        log.info("readForm -> boardNo : "+ boardNo);

        return "board/read";
    }


    @GetMapping("/update/{boardNo}")
    public String updateForm(@PathVariable int boardNo) {
        log.info("updateForm -> boardNo : " + boardNo);

        return "board/update";
    }

    @GetMapping(value = "/get", params = "register")
    public String register() {
        log.info("register : ");

        return "board/register";
    }

    @PostMapping(value = "/post", params = "register")
    public String registerPost(String bookId) {
        log.info("--registerPost--" + bookId);
        return "board/register";
    }

    @PostMapping(value = "/post", params = "update")
    public String updatePost(String bookId) {
        log.info("--updatePost--" + bookId);
        return "board/register";
    }

    @PostMapping(value = "/post", params = "delete")
    public String deletePost(String bookId) {
        log.info("--deletePost--" + bookId);
        return "board/register";
    }

    @PostMapping(value = "/post", params = "list")
    public String listPost(String bookId) {
        log.info("--listPost--" + bookId);
        return "board/register";
    }


    @GetMapping(value = "/get", params = "remove")
    public String remove() {
        log.info("--remove--");
        return "board/register";
    }
    @PostMapping(value = "/post", params = "remove")
    public String removePost(String bookId) {
        log.info("--removePost--" + bookId);
        return "board/register";
    }
    @GetMapping(value = "/get", params = "read")
    public String read() {
        log.info("--read--");
        return "board/register";
    }

    @PostMapping(value = "/{boardNo}")
    public ResponseEntity<String> modifyPost(@PathVariable("boardNo") int boardNo) {
        log.info("--modifyPost--" + boardNo);
        ResponseEntity<String> entity = new ResponseEntity<String>("Success", HttpStatus.OK);

        return entity;
    }

    @PostMapping(value = "/book")
    public ResponseEntity<String> book() {
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
