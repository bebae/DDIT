<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <title>Implicit Objects(내장 객체)</title>
</head>
<body>
<%
    // 1초마다 새로고침
    // response.setIntHeader("Refresh", 1);
%>
    <div>
        <h2>new Date() : <%=new Date()%></h2>
        <h2>new Date().toLocaleString : <%=new Date().toLocaleString()%></h2>
        <h2 id="h2"></h2>
    </div>

<script type="text/javascript">
        function gogo() {
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


            document.getElementById("h2").innerHTML = dateString + " " + timeString;
        }
        setInterval(gogo, 1000);
    </script>
</body>
</html>