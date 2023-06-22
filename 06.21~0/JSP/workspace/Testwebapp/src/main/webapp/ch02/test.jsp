<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Test.jsp 페이지 입니다.</h2>
<% String str1 = "안녕하세요 : text";  %>
<h3><%=str1%></h3>
<h2>
    <ul>
        <li>아빨로</li>
        <li><%=str1.substring(5)%></li>
        <li>JSP 테스트 중입니다.</li>
    </ul>
    <% String[] strArr = {"사과","바나나","딸기","배"}; %>
    <ul>
        <% for(String str : strArr) { %>
        <li><%=str%></li>
        <% } %>
    </ul>
</h2>
<script>
    // JavaScript code here
    var greeting = "Hello, World!";
    console.log(greeting);
    alert("!!!!!!");
    var num1 = prompt("Please enter");
    document.write("입력하신 내용 : "+num1);
</script>

</body>
</html>
