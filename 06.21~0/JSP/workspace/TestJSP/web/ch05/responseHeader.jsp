<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>InsertTitle</title>
</head>
<body>
<%
    // setHeader() 메소드 : 헤더 이름(name)에 문자열 값을 설정
    response.setHeader("Cache-control", "use_cache");
    // addHeader() 메소드 : 헤더 이름(name)에 값을 설정
    response.addHeader("contentType", "text/html; charset=UTF-8");
    // setDateHeader() 메소드 : 헤더 이름에 날짜/시간 설정
    response.setDateHeader("date", 500000L);
%>
<p>Cache-control : <%=response.getHeader("Cache-control")%></p>
<p>contentType : <%=response.getHeader("contentType")%></p>
<p>Date : <%=response.getHeader("date")%></p>

</body>
</html>