<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Cookie</title>
</head>
<body>
<%
  Cookie[] cookies = request.getCookies();
  out.print("cookies.length : " + cookies.length);
  for (Cookie cookie : cookies) {
      out.print("<p>" + cookie.getName() + "=" + cookie.getValue() + "</p>");
  }

  out.print("<p> session.getId() : " + session.getId() + "</p>");
%>

<div>
  <form action="cookie01_process.jsp" method="post">
    <p>아이디 : <input type="text" name="id" id="id"></p>
    <p>비밀번호 : <input type="password" name="password" id="password"></p>
    <p>
      <button type="submit">전송</button>
    </p>
  </form>
</div>
</body>
</html>
