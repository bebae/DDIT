package kr.or.ddit.basic.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

// http://localhost:80/highjava/servlet/ServletTest01.do       ==> 실행할 URL 주소
/*
 * - http    ==> 프로토콜
 * - localhost      ==> 컴퓨터이름(도메인명) 또는 IP주소
 * - 80             ==> 포트번호 (80일 경우 생략가능)
 * - /highjava      ==> 컨택스트패스(보통 '프로젝트명'으로 지정된다.)
 * - /servletTest01.do  ==> 서블릿 요청 URL 패턴
 */

// 이 예제는 배포서술자(web.xml)을 이용해서 실행할 Servlet을 설정하는 방식의 예제이다.

public class ServletTest01 extends HttpServlet{

    // 이 곳에서는 대부분 service()메소드나 doGet()메소드 또는 doPost()메소드를 재정의해서 작성한다.
    // doGet()메소드나 doPost()메소드는 service()메소드를 통해서 호출된다.
    // 이 메소드의 매개변수로 주어진 객체는 HttpServletRequest객체가 자동으로 저장된다.



    // doGet()메소드 ==> GET방식의 요청을 처리하는 메소드이다.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로또번호 출력
        HashSet<Integer> lottoSet = new HashSet<>();
        Random rnd = new Random();

        while (lottoSet.size() < 6) {
            lottoSet.add(rnd.nextInt(45) + 1);
        }
        ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);
        Collections.sort(lottoList);

        System.out.println(lottoList);

        response.setCharacterEncoding("utf-8"); //응답 문서의 인코딩 방식
        response.setContentType("text/html; charset=utf-8");    // 응답 문서의 ContentType 지정

        // 처리한 내용을 응답으로 보내기 위해서 PrintWeiter객체를 생성한다.
        PrintWriter out = response.getWriter();

        // 처리한 내용을 출력한다.
        // 방법1) append()메소드를 이용하여 출력한다.
        out.append("<!DOCTYPE html>")
            .append("<html>")
            .append("<head>")
            .append("<meta charset='utf-8'>")
            .append("<title>ServletTest01</title>")
            .append("</head>")
            .append("<body>")
            .append("<h2 style='text-align: center'>Servlet 프로그램 H1 부분 입니다.</h2>")
            .append("<h3>행운의 로또번호</h3>")
            .append("<ul>");
        for (int i = 0; i < lottoList.size(); i++) {
            out.append("<li>" + lottoList.get(i) + "</li>");
        }
        out.append("</ul>")
            .append("</body>")
            .append("</html>");

    }

    // doPost()메소드 ==> POST방식의 요청을 처리하는 메소드이다.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{

    }
}
