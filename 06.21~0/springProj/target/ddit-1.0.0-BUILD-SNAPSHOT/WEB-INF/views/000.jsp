<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//	mav.addObjext("data", bookVO);
%>
<!DOCTYPE html>
<html>
<head>
<title>책 상세</title>
</head>
<body>
<h1>책 상세</h1>
<!--
	BookController에서 보내준 데이터를 뷰(jsp)에 표현하도록 도와줌
	BookkController에 mav.addObject("data", bookVO); 를 선언해서 사용
-->
<form action="/create" method="post">
	<!-- 폼데이터 -->
	<p>제목 : <input type="text" name="title" value="${data.title}" readonly /></p>
	<p>카테고리 : <input type="text" name="category" value="${data.category}" readonly /></p>
	<p>가격 : <input type="number" name="price" maxLength="10" value="${data.price}" readonly /></p>
	<p>설명 : <textarea rows="5" cols="30" name="content" readonly>${data
	.content}</textarea>
	<p>
		<input type="submit" value="저장" />
		<input type="button" value="목록" />
	</p>
</form>
</body>
</html>