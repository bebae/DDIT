<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>  <!-- 이 방식 많이 씀 -->   
</head>
<body>
	<h2>국제화</h2>
	<!-- 숫자 : 3,200,100 -->
	<p>숫자 : <fmt:formatNumber value="3200100"/></p> <!-- 엄청 많이 쓰이는 방식 -->
	<p>숫자 : <fmt:formatNumber value="3200100" type="number" /></p>

	<!-- 원화 붙이기!!! -->
	<p>숫자 : <fmt:formatNumber value="3200100" type="currency" groupingUsed="true" /></p>
	<p>숫자 : <fmt:formatNumber value="3200100" type="currency" currencySymbol="금" /></p>
	<p>숫자 : <fmt:formatNumber value="0.45" type="percent" /></p>
	<p>숫자 : <fmt:formatNumber value="3200100.45" pattern=".000" /></p>

	<!-- 가장 많이 사용!!! 천단위 구분 기호, 소수점 2자리 (#,#00) -->
	<p>숫자 : <fmt:formatNumber value="3200150.456" pattern="#,#00.0#" /></p>
</body>
</html>