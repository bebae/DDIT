<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
  <title>주문 완료</title>
</head>
<body>

<jsp:include page="/welcome/menu.jsp" />

<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">주문 취소</h1>
  </div>
</div>

<% session.removeAttribute("cartlist"); %>
<div class="container">
  <h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
</div>
<div class="container">
  <p><a href="products.jsp" class="btn btn-secondary">&laquo;&nbsp;상품목록</a></p>
</div>

<jsp:include page="/welcome/footer.jsp" />


</body>
</html>