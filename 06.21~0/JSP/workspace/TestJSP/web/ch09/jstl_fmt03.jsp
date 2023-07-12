<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<html>
<head>
  <title>Insert Title</title>
</head>
<body>
  <h2>국제화</h2>
  <%-- 2023.07.07 --%>
  <p><fmt:formatDate value="<%=new Date()%>" type="date" /> </p>
  <%-- 오전 9:39:44 --%>
  <p><fmt:formatDate value="<%=new Date()%>" type="time" /> </p>
  <%-- 2023. 7. 7 오전 9:40:41 --%>
  <p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="default" timeStyle="default" /> </p>

  <p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="short" timeStyle="short" /> </p>
  <p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="medium" timeStyle="medium" /> </p>
  <p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="long" timeStyle="long" /> </p>
  <p><fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" timeStyle="full" /> </p>

  <%-- 가장 많이 사용됨!!! --%>
  <p><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd" /> </p>
  <p><fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd hh:mm:ss" /> </p>


</body>
</html>
