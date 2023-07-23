<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Session</title>
</head>
<body>
<div>
  <h3>세션 아이디 : ${sessionScope.userId}</h3>
  <h3>세션 비밀번호 : ${sessionScope.userPw}</h3>
  <form action="session02_process.jsp" method="post">
    <p>아이디 : <input type="text" name="id" value="<%=session.getAttribute("userId")%>" required autofocus /></p>
    <p>비밀번호 : <input type="text" name="passwd" value="<%=session.getAttribute("userPw")%>" required /></p>
    <p><button type="submit">전송</button></p>
  </form>
</div>
</body>
</html>
