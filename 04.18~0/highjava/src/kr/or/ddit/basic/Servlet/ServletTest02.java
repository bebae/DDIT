package kr.or.ddit.basic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 예제는 에노테이션(@webServlet)을 이용해서 Servlet을 설정하여 처리하는 예제이다.
// 애노테이션(@WebServlet)은 Servlet버전 3.0 이상에서 사용할수 있다.

// @WebServlet애노테이션의 속성들
// 1. name : 서블릿의 이름을 설정한다. (기본값 : 빈문자열"") )
// 2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다. (기본값 : 빈배열({ }) )
//		예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 때
//		예) urlPatterns={"/url1", "/url2", ...} ==> 패턴이 2개 이상일 때
// 3. value : urlPatterns속성과 기능이 같다.
// 4. description : 주석(설명글)을 설정한다.


@WebServlet(urlPatterns = {"/servletTest02.do"},
			description = "애노테이션을 이용한 서블릿 설정 연습")
public class ServletTest02 extends HttpServlet {

	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 // 처리한 내용 응답으로 보내기
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=utf-8");
		 
		 // 출력용 스트림 객체
         PrintWriter out = response.getWriter();
         
         // 내용 출력하기
         out.append("<!DOCTYPE html>")
         .append("<html>")
         .append("<head>")
         .append("<meta charset='utf-8'>")
         .append("<title>두번째 ServletTest02</title>")
         .append("</head>")
         .append("<body>")
         .append("<h2 style='text-align: center; color:red;'>")
         .append("Servlet 프로그램 H2 부분 입니다. <br>")
         .append(" 텍스트 부분입니다.<br>")
         .append("@WebServlet 애너테이션을 이용한 서블릿입니다.</h2>")
         .append("</body>")
         .append("</html>");
		 
	 }

}
