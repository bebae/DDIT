<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
%>
    <p>아이디 : <% out.print(id); %></p>
    <p>비밀번호 : <% out.print(passwd); %></p>

</body>
</html>
