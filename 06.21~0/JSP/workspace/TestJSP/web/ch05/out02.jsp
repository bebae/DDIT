<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--  폼 필드  -->
    <form action="<%=request.getContextPath()%>/ch05/out02_proces.jsp" method="post">
        <p>아이디 : <input type="text" name="id" placeholder="아이디를 입력해주세요" required /></p>
        <p>비밀번호 : <input type="text" name="passwd" placeholder="비밀번호를 입력해주세요" required /></p>
        <p>
            <button type="submit">전송</button></p>
    </form>
</body>
</html>
