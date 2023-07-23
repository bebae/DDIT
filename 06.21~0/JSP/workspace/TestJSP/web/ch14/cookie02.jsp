<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Cookie</title>
</head>
<body>
<%
  Cookie[] cookies = request.getCookies();
  out.print("cookies.length : " + cookies.length);
  out.print("<hr />");
  int i = 1;
  for (Cookie cookie : cookies) {
      out.print("쿠키["+ i + "] : "+ cookie + " <br />");
      out.print("쿠키 속성 명["+ i + "] : "+ cookie.getName() + " <br />");
      out.print("쿠키 값 명["+ i + "] : "+ cookie.getValue() + " <br />");
      out.print("----------------------------------------------------------<br />");
      i++;
  }

  out.print("<p> session.getId() : " + session.getId() + "</p>");
%>


</body>
</html>
