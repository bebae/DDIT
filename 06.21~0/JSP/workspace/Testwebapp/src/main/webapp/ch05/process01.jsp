<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Implicit Objects</title>
</head>
<body>
    <%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    // 헤더(페이지 자체)에 있는 host 라는 name에 매핑되어 있는 값 가져오기
    String hostValue = request.getHeader("host");
    String alValue = request.getHeader("accept-language");
    %>
    <h3>아이디 : <%=id%></h3>
    <h3>비밀번호 : <%=pass%></h3>
    <h3>누구냐 : <%=hostValue%></h3>
    <h3>인코딩 : <%=alValue%></h3>

    <c:set var="id" value="<%=id%>" />
    <c:set var="pass" value="<%=pass%>" />
    <p>ID(JSTL) : ${id}</p>
    <p>pass(JSTL) : ${pass}</p>

</body>
</html>