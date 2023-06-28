<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="page_errorPage_error.jsp" %>
<!-- 오류 발생 시 page 디렉티브, 오류처시 jsp로 이동 -->
<!DOCTYPE html>
<html>
<head>
    <title>Directive Tag</title>
</head>
<body>
    <%
    String str = null;
    // 오류발생
    out.print(str.toString());
    %>
</body>
</html>