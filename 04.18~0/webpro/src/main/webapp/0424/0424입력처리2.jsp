<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
</head>
<body>
    <h1>JSP : Java Server Page</h1>
    
    <!--
    <%
        String userId = request.getParameter("id");
        int userNum = Integer.parseInt(request.getParameter("num"));
        String userFile = request.getParameter("file");
        // db 처리, 파일 처리 
    %>  -->

    <p> 아이디 : <%= userId %></p>
    <p> 번호 : <%= userNum %></p>
</body>
</html>
