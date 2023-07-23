<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
  <title>세샨 유효 시간 변경</title>
</head>
<body>

  <h3>세션 유효 시간 변경</h3>
<%
  // session available time check(세션 유효 시간 확인)
  session.setMaxInactiveInterval(60*30);
  int time = session.getMaxInactiveInterval(); // session 초단위

  out.print("세션 유효 시간 : " + time + "초<br>");
%>

  <h3>세션 유효 시간 변경 후</h3>
<%
  session.setMaxInactiveInterval(60*60);
  time = session.getMaxInactiveInterval();

  out.print("세션 유효 시간 : " + time + "초<br>");
%>

</body>
</html>
