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
<!--  ////////////// haeder (menu.jsp) 시작 ////////////  -->
<%@ include file="./menu.jsp" %>
<!--  ////////////// haeder 끝 ////////////  -->
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
            <h3>Today is <%=new Date()%></h3>
            <h3>
                <%
                Date day = new Date();
                String am_pm;
                int hour = day.getHours();
                int minute = day.getMinutes();
                int second = day.getSeconds();

                if (hour/12 == 0) {     // 0 ~ 11 => 0
                    am_pm = "AM";
                } else {    // 12 ~ 24 => 1 or 2
                    am_pm = "PM";
                    hour -= 12;
                }
                String CT = hour + ":" + minute + ":" + second + " " + am_pm;
                out.print("현재 접속 시각 : " + CT + "\n");
                %>
            </h3>
        </div>
    </div>
<!--  ////////////// footer (footer.jsp) 시작 ////////////  -->
<%@ include file="./footer.jsp" %>
<!--  ////////////// footer 끝 ////////////  -->
</body>
</html>