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
        String name = request.getParameter("name");
    %>
    <h3>Name : <%=name%></h3>

    <!-- JSTL 변수 -->
    <c:set var="name" value="<%=name%>" />
    <p>이름(JSTL) : ${name}</p>
    <script type="text/javascript">
    	let name = "${name}";
    	console.log("name : "+name);
    </script>

</body>
</html>