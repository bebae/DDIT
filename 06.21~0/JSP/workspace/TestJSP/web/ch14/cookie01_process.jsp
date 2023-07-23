<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Cookie</title>
</head>
<body>
<%
  String userId = request.getParameter("id");
  String userPw = request.getParameter("password");

  if (userId.equals("admin") && userPw.equals("java") ) {

  Cookie cookieId = new Cookie("userId", userId);
  response.addCookie(cookieId);

  Cookie cookiePw = new Cookie("userPw", userPw);
  response.addCookie(cookiePw);
  out.println("<p>Cookie 생성 성공!</p>");
  out.println("<p>" + userId + "님 환영합니다.</p>");
  } else {
    out.println("<p>Cookie 생성 실패!</p>");
  }

%>
<div>
  <p><a href="cookie01.jsp">cookie01.jsp로 이동</a></p>
</div>
</body>
</html>
