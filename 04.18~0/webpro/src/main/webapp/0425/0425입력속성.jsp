<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		String userAge = request.getParameter("age");
		String userName = request.getParameter("name");
	%>
	<span>아이디   : </span><%= userId %><br>
	<span>비밀번호 : </span><%= userPass %><br>
	<span>나이     :</span><%= userAge %><br>
	<span>이름     :</span><%= userName %>
</body>
</html>