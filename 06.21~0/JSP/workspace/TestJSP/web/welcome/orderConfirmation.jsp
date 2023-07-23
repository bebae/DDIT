<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
  <title>주문 정보</title>
</head>
<body>
  <%
    String shippingCartId = "";
    String shippingName = "";
    String shippingShippingDate = "";
    String shippingCountry = "";
    String shippingZipCode = "";
    String shippingAddressName = "";

    Cookie[] cookies = request.getCookies();

    for (Cookie cookie : cookies) {
      String cookieName = cookie.getName();
      String cookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");

      switch (cookieName) {
        case "shipping_cartId":
          shippingCartId = cookieValue;
          break;
        case "shipping_name":
          shippingName = cookieValue;
          break;
        case "shipping_shippingDate":
          shippingShippingDate = cookieValue;
          break;
        case "shipping_country":
          shippingCountry = cookieValue;
          break;
        case "shipping_zipCode":
          shippingZipCode = cookieValue;
          break;
        case "shipping_addressName":
          shippingAddressName = cookieValue;
          break;
        default:
          // Handle any other cookies if necessary
          break;
      }
    }


    ArrayList<ProductVO> cartlist = (ArrayList<ProductVO>) session.getAttribute("cartlist");
  %>
  <c:set var="cartlist" value="<%=cartlist%>" />

  <%@ include file="./menu.jsp" %>

  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">주문 정보</h1>
    </div>
  </div>
  <div class="container col-8 alert alert-info">
    <div class="text-center">
      <h1>영수증</h1>
      <div class="row justify-content-between">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
          <strong>배송 주소</strong><br>
          <p class="mb-1">성명: <%=shippingName%></p>
          <p class="mb-1">우편번호: <%=shippingZipCode%></p>
          <p class="mb-0">주소: <%=shippingAddressName%>&nbsp;<%=shippingCountry%></p>
        </div>
        <div class="col-sm-3">
          <p class="mb-0"><em>배송일: <%=shippingShippingDate%></em></p>
        </div>
      </div>
      <div class="col-sm-12 mt-3">
        <table class="table table-hover">
          <tr>
            <th class="text-center">상품명</th>
            <th class="text-center">#</th>
            <th class="text-center">가격</th>
            <th class="text-center">소계</th>
          </tr>
          <c:forEach var="vo" items="${cartlist}" varStatus="stat">
            <c:set var="total" value="${total + vo.unitPrice * vo.quantity}" />
            <tr>
              <td class="text-center"><em>${vo.pname}</em></td>
              <td class="text-center">${vo.quantity}</td>
              <td class="text-center"><fmt:formatNumber value="${vo.unitPrice}" pattern="#,#00" /></td>
              <td class="text-center"><fmt:formatNumber value="${vo.quantity * vo.unitPrice}" pattern="#,#00" /></td>
            </tr>
          </c:forEach>
          <tr>
            <td></td>
            <td></td>
            <td class="text-right">총액 :</td>
            <td class="text-center text-danger"><strong><fmt:formatNumber value="${total}" pattern="#,###"/>원</strong></td>
          </tr>
        </table>
        <div class="">
          <a href="shippingInfo.jsp?cartId=<%=shippingCartId%>" class="btn btn-secondary" role="button">이전</a>
          <a href="thankCustomer.jsp" role="button" class="btn btn-success">주문 완료</a>
          <a href="checkOutCancelled.jsp" class="btn btn-secondary" role="button">취소</a>
        </div>
      </div>
    </div>
  </div>


  <%@ include file="./footer.jsp" %>

</body>
</html>
