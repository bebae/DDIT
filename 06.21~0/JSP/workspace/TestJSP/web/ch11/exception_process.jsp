<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page errorPage="exception_error.jsp" %>--%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--
  POST 방식
  요청 URL : exception_process.jsp
  요청 파라미터 : {num1=12&num2=6}
--%>
  <%
    String num1 = request.getParameter("num1"); // "12"
    String num2 = request.getParameter("num2"); // 6

    // 문자를 숫자로 변환
    int a = Integer.parseInt(num1);
    int b = Integer.parseInt(num2);
    int c = a / b;
    out.print("<p>" + num1 + " / " + num2 + " = " + c + "</p>");

  %>
</body>
</html>
