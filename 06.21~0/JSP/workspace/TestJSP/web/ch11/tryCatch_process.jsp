<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page errorPage="exception_error.jsp" %>--%>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <%
    try {
      String num1 = request.getParameter("num1"); // "12"
      String num2 = request.getParameter("num2"); // 6

      // 문자를 숫자로 변환
      int a = Integer.parseInt(num1);
      int b = Integer.parseInt(num2);
      int c = a / b;
      out.print("<p>" + num1 + " / " + num2 + " = " + c + "</p>");
    } catch (NumberFormatException e) {
      // FIXME : 오류 발생 시 tryCatch_error.jsp로 포워딩
      /*
          1) forwarding : jsp를 해석 -> 컴파일 -> html 리턴 받음, 데이터를 전다 할 수 있음
          2) redirect : URL을 재요청. 데이터를 전달하기 어려움
       */
      RequestDispatcher dispatcher = request.getRequestDispatcher("tryCatch_error.jsp");
      dispatcher.forward(request, response);
    }

  %>
</body>
</html>
