<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.print("오늘의 날짜 및 시간 : ");
    out.print(Calendar.getInstance().getTime());
%>
</body>
</html>
