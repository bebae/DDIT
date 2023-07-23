<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Filter Test</title>
</head>
<body>
<div>
  <form action="<%=request.getContextPath()%>/ch12/filter02_process.jsp" method="post">
    <p>아이디 : <input type="text" name="id"></p>
    <p>비밀번호 : <input type="password" name="passwd"></p>
    <button type="submit">전송</button>
  </form>
</div>

</body>
</html>
