<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Scripting Tag</title>
</head>
<body>
<h1>JSP</h1>

<h3>예제 1번</h3>
<%! int data = 50; %>
<p><% out.println("data : "+data); %></p>

<br><h3>예제 2번</h3>
<%!
int sum(int x, int y) {
    return x + y;
}
%>
<% out.println("2 + 3 = "+sum(2,3)); %>

<br><br><h3>예제 3번</h3>
<%!
int mul(int x, int y) {
    return x * y;
}
%>
<%
for (int i = 2; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
        out.println(i + " X " + j + " = " + mul(i, j) + "<br>");
    }
    out.println("<br>");
}
%>

</body>
</html>