<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
  <script src="/resources/js/jquery-3.6.0.js"></script>
  <title>주문 정보</title>
  <script type="text/javascript">
    $(function(){
        $("#idThank").on("click", function(){
            let shippingDate = "${map.shippingDate}";
            let cartId = "${map.cartId}";

            console.log("shipping : " + shippingDate);
            console.log("cartId : " + cartId);

            let formData = new FormData();
            // <input type="text" name="shipping" ...>
            formData.append("shippingDate", shippingDate);
            // <input type="text" name="cartId" ...>
            formData.append("cartId", cartId);

            // 아작났어유 피씨다타써
            // contentType : 보내는 타입
            // dataType : 응답 타입
            $.ajax({
                url : "/shopping/thankCustomer",
                processData: false,
                contentType : false,
                data: formData,
                type: "post",
                database : "text",
                success: function(result) {
                    console.log("result : " + result);
                    if (result === "success") {
                        location.href = "/shopping/thankCustomer";
                    } else {
                        console.log("error 발생 : " + result);
                    }
                }
            });
        });
    });
  </script>
</head>
<body>

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
          <p class="mb-1">성명: ${map.name}</p>
          <p class="mb-1">우편번호: ${map.zipCode}</p>
          <p class="mb-0">주소: ${map.addressName} ${map.country}</p>
        </div>
        <div class="col-sm-3">
          <p class="mb-0"><em>배송일: ${map.shippingDate}</em></p>
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
          <c:forEach var="vo" items="${sessionScope.cartlist}" varStatus="stat">
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
          <a href="/shopping/shippingInfo?cartId=${param.cartId}" class="btn btn-secondary" role="button">이전</a>
          <a href="#" role="button" id="idThank" class="btn btn-success">주문 완료</a>
          <a href="/shopping/checkOutCancelled" class="btn btn-secondary" role="button">취소</a>
        </div>
      </div>
    </div>
  </div>


</body>
</html>
