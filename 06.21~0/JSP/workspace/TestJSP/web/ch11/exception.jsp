<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Exception</title>
</head>
<body>
  <!--
  POST 방식
  요청 URL : exception_process.jsp
  요청 파라미터 : {num1=12&num2=6}

  GET 방식
  요청 URL : exception_process.jsp?num1=12&num2=6
  요청 파라미터 : num1=12&num2=6
  -->
  <form action="exception_process.jsp" method="post">
    <p>숫자 1 : <input type="text" name="num1"></p>
    <p>숫자 2 : <input type="text" name="num2"></p>
    <button type="submit">나누기</button>
  </form>
</body>
</html>
