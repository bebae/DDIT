<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>InsertTitle</title>
</head>
<body>
    <nav class="navbar navber-expand navbar-dark bg-dark">
        <!-- container : 내용이 들어갈 때 -->
        <div class="container">
            <a href="/ch02/welcome.jsp" class="navbar-brand">Home</a>
        </div>
    </nav>
<%! // 선언문 (전역변수)
    String greeting = "Welcome to 김민수 World";
    String tagline = "Welcome to 김민수Market!";
%>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><%=greeting%></h1>
        </div>
    </div>
    <div class="container">
        <div class="text-center">
            <h3><%= tagline%></h3>
            <p>Today is <%=new Date()%></p>
        </div>
    </div>
    <footer class="container">
        <p>&copy; WebMaket</p>
    </footer>
</body>
</html>