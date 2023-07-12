<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Internationalization</title>  <!-- 이 방식은 잘 안씀  -->
</head>
<body>
	<h3>현재 로케일의 국가, 날씨, 통화</h3>
	<%
		Locale locale = request.getLocale();
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(
				DateFormat.FULL, locale);
		NumberFormat numberFormat = 
				NumberFormat.getNumberInstance(locale); //대한민국 스타일로 숫자출력
	%>
	<p>국가 : <%=locale.getDisplayCountry() %></p>
	<p>날짜 : <%=dateFormat.format(currentDate)%></p>
	<p>숫자 : <%=numberFormat.format(12345.67)%></p> 
</body>
</html>