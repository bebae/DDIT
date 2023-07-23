<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Session Delete</title>
</head>
<body>

  <h4>세션 삭제 전</h4>
<%
  String name = null; // session name
  String value; // session value
  Enumeration<String> en = session.getAttributeNames();

  while (en.hasMoreElements()) {
    name = en.nextElement();
    value = session.getAttribute(name).toString();

    out.print("설정된 세션 속성 명 : " + name + "<br>");
    out.print("설정된 세션 속성 값 : " + value + "<br>");
    out.print("================================<br>");
  }

  session.removeAttribute(name);
%>
  <h4>세션 삭제 후</h4>
<%


  en = session.getAttributeNames();
  while (en.hasMoreElements()){
    name = en.nextElement();
    value = session.getAttribute(name).toString();

    out.print("설정된 세션 속성 명 : " + name + "<br>");
    out.print("설정된 세션 속성 값 : " + value + "<br>");
    out.print("================================<br>");
  }
%>

</body>
</html>
