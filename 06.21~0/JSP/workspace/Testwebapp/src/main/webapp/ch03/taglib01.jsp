<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>InsertTitle</title>
</head>
<body>
<!--
    var : JSTL 변수
    value : 값
    scope : 활용범위(page/reqyest/session/application)
-->
<% String memId = "철수"; %>
<c:set var="memId" value="김민수" scope="page" />
<p>${memId}</p>
<p><%=memId%></p>

</body>
</html>