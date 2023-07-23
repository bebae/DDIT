<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Session</title>
</head>
<body>
<div>
  <%

    String user_id = (String)session.getAttribute("userId");
    String user_pw = (String)session.getAttribute("userPw");

    out.println("설정된 셰션의 속성 값[1] : " + user_id + "<br/>");
    out.println("설정된 셰션의 속성 값[2] : " + user_pw + "<br/>");

  %>
</div>
</body>
</html>
