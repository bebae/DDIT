<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Session</title>
</head>
<body>
<%
  int a = 10;
  double b = 20.2;
  char c = 'a';
  session.setAttribute("a", a);
  session.setAttribute("b", b);
  session.setAttribute("c", c);

  out.print("a = " + session.getAttribute("a") + "<br>");
  out.print("b = " + session.getAttribute("b") + "<br>");
  out.print("c = " + session.getAttribute("c") + "<br>");

  String name; // session name
  String value; // session value
  Enumeration<String> en = session.getAttributeNames();

  while (en.hasMoreElements()) {
    name = en.nextElement();
    value = session.getAttribute(name).toString();

    out.print("설정된 세션 속성 명 : " + name + "<br>");
    out.print("설정된 세션 속성 값 : " + value + "<br>");
    out.print("================================<br>");
  }
%>


</body>
</html>
