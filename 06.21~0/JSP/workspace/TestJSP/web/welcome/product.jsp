<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="exceptionNoProductId.jsp" %>

<%
  // 싱글톤
  ProductRepository dao = ProductRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
  <title>상품 상세 정보</title>
  <style>
      .container img {
          width: 100%;
          height: 300px;
      }
  </style>
</head>
<body>
<jsp:include page="/welcome/menu.jsp" />

<%--  상품 상세 시작  --%>
<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">상품정보</h1>
  </div>
</div>
<% // 스크립틀릿
  // 요청 URI : product.jsp?productId = P1234
  // 요청 URL : product.jsp
  // 요청 파라미터 : productId=P1234
  // 요청 방식 : get
  String productId = request.getParameter("productId");

  ProductVO productVO = dao.getProductById(productId);
%>
<%-- 자바의 변수를 JSTL 변수로 가져오는 부분 --%>
<c:set var="vo" value="<%=productVO%>" />
<%--  내용  --%>
<div class="container">
  <div class="row">
    <%-- 상품 이미지 --%>
    <div class="col-md-5">
      <img src="<%=request.getContextPath()%>/images/${vo.filename}" alt="${vo.pname}">
    </div>
    <!-- 6크기의 1열 (컬럼=필드=속성=애트리뷰트) -->
    <div class="col">
      <h3>
        ${vo.pname}
        <a href="<%=request.getContextPath()%>/welcome/logout.jsp" class="btn btn-sm btn-success -pull-right ml-3">Logout</a>
      </h3>


      <p>${vo.description}</p>
      <p>
        <b>상품 코드 : </b>
        <span class="badge badge-danger">${vo.productId}</span>
      </p>
      <p><b>제조사 : </b>${vo.manufacturer}</p>
      <p><b>분류 : </b>${vo.category}</p>
      <p><b>재고 수 : </b>${vo.unitsInStock}</p>
      <p>
        상품 주문
        장바구니
        <a href="<%=request.getContextPath()%>/welcome/products.jsp" class="btn btn-secondary">상품 목록&nbsp;&raquo;</a>
      </p>
    </div>
  </div>
</div>

<%--  상품 상세 끝  --%>

<jsp:include page="/welcome/footer.jsp" />
</body>
</html>