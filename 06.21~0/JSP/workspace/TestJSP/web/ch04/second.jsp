<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Action Tag</title>
</head>
<body>
    <h3>이 파일은 second.jsp 입니다.</h3>
    <p>Today is : <%=request.getParameter("date")%></p>
</body>
</html>