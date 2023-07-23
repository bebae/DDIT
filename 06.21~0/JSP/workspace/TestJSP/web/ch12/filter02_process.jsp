<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Filter Test</title>
</head>
<body>
  <%
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
  %>
  <div>
    <!--
      1) /ch12/filter01_process.jsp?name=홍길동
      2) /ch12/filter01_process.jsp?name=
        null 값일 때
    -->
    <p>입력된 ID 값 : <%=id%></p>
    <p>입력된 PASSWORD 값 : <%=passwd%></p>

  </div>
</body>
</html>
