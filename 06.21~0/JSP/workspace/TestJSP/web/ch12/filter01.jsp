<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Filter Test</title>
</head>
<body>
  <div>
    <form action="<%=request.getContextPath()%>/ch12/filter01_process.jsp" method="post">
      <p>이름 : <input type="text" name="name" /></p>
      <p><button type="submit" name="">전송</button></p>
    </form>
  </div>
</body>
</html>
