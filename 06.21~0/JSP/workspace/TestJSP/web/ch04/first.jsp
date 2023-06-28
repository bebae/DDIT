<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <title>Action Tag</title>
</head>
<body>
    <h3>이 파일은 first.jsp 입니다.</h3>
    <!--  forward 액션 태그 : 다른 페이지로 이동(페이지 흐름 제어)
        요청 URI : second.jsp?date=오늘날짜
        요청파라미터(Http 파라미터 = QueryString) : date = 오늘날짜 :=: name = value
    -->
    <jsp:forward page="second.jsp">
        <jsp:param name="date" value="<%=new Date()%>" />
    </jsp:forward>
    <p>===first.jsp의 페이지</p>
</body>
</html>