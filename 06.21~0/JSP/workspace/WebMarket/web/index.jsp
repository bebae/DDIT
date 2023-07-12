<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <title>JSP index</title>
  <style>
    #section {
      width: 80%;
      margin: 100px auto;
      text-align: center;
    }
  </style>
</head>
<body>
<section id="section">
  <h1>JSP Index</h1>
  <h3><a href="<c:url value="/welcome.do"/>">Welcome JSP</a></h3>
</section>
</body>
</html>
