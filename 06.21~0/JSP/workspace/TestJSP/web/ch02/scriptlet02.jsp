<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>InsertTitle</title>
</head>
<body>
<h1>JSP</h1>

<h3>예제 1</h3>
<%  // 스크립틀릿 태그
for (int i = 0; i <= 10; i++) {
    if (i % 2 == 0) {
        // out : JSP 기본 객체(화면에 출력)
        out.print("<span>"+i+" </span>");
    }
}
%>

</body>
</html>