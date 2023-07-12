<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>서비스 문제 발생</title>
</head>
<body>

  <p>잘못된 데이터가 입력되었습니다.</p>
  <p>숫자 1 : <%=request.getParameter("num1")%></p>
  <p>숫자 2 : <%=request.getParameter("num2")%></p>

</body>
</html>