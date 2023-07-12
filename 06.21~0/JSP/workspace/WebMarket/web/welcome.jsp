<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>InsertTitle</title>
</head>
<body>
<%@ include file="./menu.jsp" %>

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">도서 웹 쇼핑몰</h1>
        </div>
    </div>
    <div class="container">
        <div class="text-center">
            <h3>Welcome to Web Market</h3>
            <h3 id="time">

            </h3>
        </div>
    </div>
<%@ include file="./footer.jsp" %>

</body>
</html>