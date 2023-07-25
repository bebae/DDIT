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
<!--  ////////////// haeder (menu.jsp) 시작 ////////////  -->
<%@ include file="./menu.jsp" %>
<!--  ////////////// haeder 끝 ////////////  -->
<%! // 선언문 (전역변수)
    String greeting = "Welcome to 김민수 World";
    String tagline = "Welcome to 김민수Market!";
%>

    <c:set var="tagline" value="<%=tagline%>" />

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><%=greeting%></h1>
        </div>
    </div>
    <div class="container">
        <div class="text-center">
            <h3><%= tagline%></h3>
            <h3>Today is <%=new Date()%></h3>
            <h3 id="time">
                <%=tagline%>
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
<script type="text/javascript">
    // 현재시간 처리
    function gogo() {
        // JSTL 변수를 JS 변수에 할당
        let tagline = "${tagline}";
        console.log("tagLine : " + tagline);

        // h3 select = #time
        let h3 = document.getElementById("time");

        let today = new Date();
        console.log(today)

        let year = today.getFullYear();
        let month = ('0' + (today.getMonth() + 1)).slice(-2);
        let day = ('0' + today.getDate()).slice(-2);

        let dateString = year + '-' + month + '-' + day;
        console.log(dateString);

        let hours = ('0' + today.getHours()).slice(-2);
        let minutes = ('0' + today.getMinutes()).slice(-2);
        let seconds = ('0' + today.getSeconds()).slice(-2);

        let timeString = hours + ":" + minutes + ":" + seconds;
        console.log(timeString);

        h3.innerHTML = tagline + " " + "현재 접속 시각 : " + dateString + " " + timeString;
    }
    setInterval(gogo, 1000);
</script>
</body>
</html>