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
<jsp:include page="/welcome/menu.jsp" />

<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">주문 완료</h1>
  </div>
</div>

<div class="container">
  <h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
  <p>주문은 <%=shippingShippingDate%>에 배송될 예정입니다.</p>
  <p>주문번호 : <%=shippingCartId%></p>
</div>
<div class="container">
  <p><a href="products.jsp" class="btn btn-secondary">&laquo;&nbsp;상품 목록</a></p>
</div>

<jsp:include page="/welcome/footer.jsp" />

<%
  session.removeAttribute("cartlist");
  for (Cookie cookie : cookies) {
    cookie.setMaxAge(0);
  }
%>

</body>
</html>