<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/bootstrap.min.css">
    <title>상품 목록</title>
    <style>
        .container img {
            width: 100%;
            height: 350px;
        }
    </style>
</head>
<body>
<!-- scope : 영역
    토르의 활동 영역 : 대전          / 대한민국          / 아시아                  / 지구
    scope 영역       : page(동일jsp) / request(동일요청) / session(동일웹브라우저) / application(모든 웹브라우저)
    scope 객체       : pageContext   / request           / session                 / application
-->

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">상품 목록</h1>
        </div>
    </div>
    <div class="container">
        <div class="row mb-4" style="justify-content: right">
            <a href="/shopping/addProduct" class="btn btn-primary">상품 추가</a>
        </div>
        <div class="row" align="center">
            <c:forEach var="vo" items="${listOfProducts}" varStatus="stat">
                <div class="col-md-4">
                    <c:if test="${vo.filename != null}">
                        <img src="<%=request.getContextPath()%>/resources/images/${vo.filename}" alt="${vo.filename}">
                    </c:if>
                    <c:if test="${vo.filename == null}">
                        <img src="https://via.placeholder.com/350" alt="임시이미지+${vo.productId}">
                    </c:if>
                    <h3>${vo.pname}</h3>
                    <p>${vo.description}</p>
                    <p><fmt:formatNumber type="Number" value="${vo.unitPrice}" pattern="#,###" />원</p>
                    <p><a href="/shopping/product?productId=${vo.productId}" class="btn btn-secondary" role="button">상세정보</a></p>
                </div>
            </c:forEach>
        </div>
    </div>


</body>
</html>