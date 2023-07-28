<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
  <title>장바구니</title>
  <style>
    #table1 {
        width: 100%;
        border-collapse: collapse;
    }

    #table1 td:nth-child(1){
        text-align:left;
    }

    #table1 td:nth-child(2){
        text-align:right;
    }

    .noItem {
        text-align: center;
    }
  </style>
</head>
<body>
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">상품정보</h1>
    </div>
  </div>

  <!-- 장바구니 상세 내역 시작 -->
  <div class="container">
    <div class="row">
      <table id="table1">
        <tr>
          <!-- 장바구니 자체를 삭제 -->
          <td><a href=/shopping/deleteCart?cartId=${cartId}" class="btn btn-danger">전체 삭제하기</a></td>
          <td><a href="/shopping/shippingInfo?cartId=${cartId}" class="btn btn-success">주문하기</a></td>
        </tr>
      </table>
    </div>

    <div class="pt-lg-5">
      <table class="table table-hover">
        <tr>
          <th>상품</th>
          <th>가격</th>
          <th>수량</th>
          <th>금액</th>
          <th>비고</th>
        </tr>
<%--        장바구니에 상품이 없을 떄--%>
        <c:if test="${empty cartlist}">
          <tr class="noItem">
            <td colspan="5">장바구니에 상품이 없습니다.</td>
          </tr>
        </c:if>
<%--        장바구니에 상품이 있을 때--%>
        <c:if test="${not empty cartlist}">
          <!-- List<ProductVO> cartList
          1. 각 scope(영역)을 먼저 스캔
            1) pageScope.cartList : pageContext.setAttribute("cartList")의 결과 데이터를 찾음
            2) requestScope.cartList : requestScope.setAttribute("cartList")의 결과 데이터를 찾음
            3) sessionScope.cartList : session.setAttribute("cartList")의 결과 데이터를 찾음
            4) applicationScope.cartList : application.setAttribute("cartList")의 결과 데이터를 찾음
          2. 1에 없을 때 model.addObjext("cartList", 결과 데이터) 스캔
          3. 1과 2에 없을 떄 null
          -->

          <c:forEach var="productVO" items="${cartlist}" varStatus="stat">
            <c:set var="amount" value="${productVO.unitPrice * productVO.quantity}" />
            <c:set var="total" value="${total + amount}" />
            <tr>
              <td>${productVO.productId}-${productVO.pname}</td>
              <td><fmt:formatNumber value="${productVO.unitPrice}" pattern="#,#00" /></td>
              <td>${productVO.quantity}</td>
              <td><fmt:formatNumber value="${amount}" pattern="#,##0" /></td>
              <td><a href="removeCart?cartId=${productVO.productId}" class="badge badge-danger p-2">삭제</a></td>
            </tr>
          </c:forEach>
          <tr>
            <td></td>
            <td></td>
            <td>총액</td>
            <td><strong><fmt:formatNumber value="${total}" pattern="#,#00" /></strong>원</td>
            <td></td>
          </tr>
        </c:if>
      </table>
      <a href="/shopping/products" class="btn btn-secondary">&laquo;&nbsp;쇼핑 계속하기</a>
    </div>
  </div>


  <script type="text/javascript">
    <%--window.onload = function(){--%>
    <%--   alert("확인용 : " + ${cartlist});--%>
    <%--   console.log(${cartlist});--%>
    <%--}--%>
  </script>
</body>
</html>
