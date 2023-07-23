<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <title>페이지 오류</title>
</head>
<body>

    <jsp:include page="/welcome/menu.jsp" />


    <div class="jumbotron">
        <div class="container">
            <h2 class="alert alert-danger">해당 페이지를 찾을 수 없습니다.</h2>
        </div>
    </div>

    <div class="container">
        <p><%=request.getRequestURI()%></p>
        <p><a href="products.jsp" class="btn btn-secondary">상품목록&nbsp;&raquo;</a></p>
    </div>

    <jsp:include page="/welcome/footer.jsp" />
</body>
</html>