<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
  <title>주문 완료</title>
</head>
<body>


<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">주문 완료</h1>
  </div>
</div>

<div class="container">
  <h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
  <p>주문은 ${shippingMap.shippingDate}에 배송될 예정입니다.</p>
  <p>주문번호 : ${shippingMap.cartId}</p>
</div>
<div class="container">
  <p><a href="/shopping/products" class="btn btn-secondary">&laquo;&nbsp;상품 목록</a></p>
</div>


</body>
</html>