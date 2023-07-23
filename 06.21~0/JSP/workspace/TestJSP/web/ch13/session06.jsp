<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
  <title>Session Delete</title>
</head>
<body>

  <h4>세션 삭제 전</h4>
<%
  String userId = (String)session.getAttribute("userId");
  String userPw = (String)session.getAttribute("userPw");
  out.println("getUserId: " + session.getId());

  // 클라이언트가 가진 세션이 유효한가 확인
  if (request.isRequestedSessionIdValid()) {
    out.println("<p>세션이 유효합니다.</p>");
  } else {
    out.println("<p>세션이 유효하지 않습니다.</p>");
  }

  // 세션 모드 정보 삭제
  session.invalidate();
%>
  <h4>세션 삭제 후</h4>
<%

  // 클라이언트가 가진 세션이 유효한가 확인
  if (request.isRequestedSessionIdValid()) {
    out.println("<p>세션이 유효합니다.</p>");
  } else {
    out.println("<p>세션이 유효하지 않습니다.</p>");
  }
%>

</body>
</html>
