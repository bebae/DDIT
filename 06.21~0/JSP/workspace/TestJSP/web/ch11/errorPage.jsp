<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page errorPage="errorPage_error.jsp" %>
<html>
<head>
  <title>Exception</title>
</head>
<body>
  <!-- null 일 경우 대문자 변화 시 오류 발생 -->
  name 파라미터 : <%=request.getParameter("name").toUpperCase()%>
</body>
</html>
