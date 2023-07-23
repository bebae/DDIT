<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="vo.ProductVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
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
  <jsp:include page="/welcome/menu.jsp" />
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">상품정보</h1>
    </div>
  </div>
  <%
    // addCart.jsp 안에 cartlist라는 세션 속셩명에 list를 매핑
    List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");

//    out.println("cartlist : " + cartlist);

    // 세션 고유 아이디
    String cartId = session.getId();
//    out.print(("<p>" + cartId + "</p>"));
  %>
  <c:set var="cartlist" value="<%=cartlist%>" />
  <c:set var="cartId" value="<%=cartId%>" />

  <!-- 장바구니 상세 내역 시작 -->
  <div class="container">
    <div class="row">
      <table id="table1">
        <tr>
          <!-- 장바구니 자체를 삭제 -->
          <td><a href="<%=request.getContextPath()%>/welcome/deleteCart.jsp?cartId=${cartId}" class="btn btn-danger">전체 삭제하기</a></td>
          <td><a href="<%=request.getContextPath()%>/welcome/shippingInfo.jsp?cartId=${cartId}" class="btn btn-success">주문하기</a></td>
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
        <c:if test="${cartlist == null}">
          <tr class="noItem">
            <td colspan="5">장바구니에 상품이 없습니다.</td>
          </tr>
        </c:if>
<%--        장바구니에 상품이 있을 때--%>
        <c:if test="${cartlist != null}">

          <c:forEach var="productVO" items="${cartlist}" varStatus="stat">
            <c:set var="amount" value="${productVO.unitPrice * productVO.quantity}" />
            <c:set var="total" value="${total + amount}" />
            <tr>
              <td>${productVO.productId}-${productVO.pname}</td>
              <td><fmt:formatNumber value="${productVO.unitPrice}" pattern="#,#00" /></td>
              <td>${productVO.quantity}</td>
              <td><fmt:formatNumber value="${amount}" pattern="#,#00" /></td>
              <td><a href="removeCart.jsp?cartId=${productVO.productId}" class="badge badge-danger p-2">삭제</a></td>
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
      <a href="<%=request.getContextPath()%>/welcome/products.jsp" class="btn btn-secondary">&laquo;&nbsp;쇼핑 계속하기</a>
    </div>
  </div>


  <jsp:include page="/welcome/footer.jsp" />
</body>
</html>
