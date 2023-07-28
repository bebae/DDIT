<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>InsertTitle</title>
</head>
<body>

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">배송 정보</h1>
        </div>
    </div>
    <div class="container">
        <form action="/shopping/processShippingInfo" method="post" class="form-horizontal">
            <%-- controller에서 cartId를 지정해줘야 사용가능 --%>
            <input type="hidden" name="cartId" value='${param.cartId}' /><br/><br/>
            <div class="form-group row">
                <lable class="col-sm-2">성명</lable>
                <div class="col-sm-3">
                    <input type="text" name="name" class="form-control" required>
                </div>
            </div>
            <div class="form-group row">
                <lable class="col-sm-2">배송일</lable>
                <div class="col-sm-3">
                    <input type="date" name="shippingDate" class="form-control" required>
                    (yyyy-MM-dd)
                </div>
            </div>
            <div class="form-group row">
                <lable class="col-sm-2">국가명</lable>
                <div class="col-sm-3">
                    <input type="text" name="country" class="form-control" required>
                </div>
            </div>
            <div class="form-group row">
                <lable class="col-sm-2">우편번호</lable>
                <div class="col-sm-3">
                    <input type="text" name="zipCode" class="form-control" required>
                </div>
            </div>
            <div class="form-group row">
                <lable class="col-sm-2">주소</lable>
                <div class="col-sm-3">
                    <input type="text" name="addressName" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="/shopping/cart?cartId=${param.cartId}" class="btn btn-secondary" role="button">이전</a>
                    <input type="submit" value="등록" class="btn btn-primary">
                    <a href="/shopping/checkOutCancelled" class="btn btn-secondary" role="button">취소</a>
                    <button type="button" class="badge btn-primary" onclick="autoFillForm()">자동 입력</button>
                </div>
            </div>
        </form>
    </div>


<script>
    function autoFillForm() {
        // 값을 자동으로 채울 변수 설정
        let name = "홍길동";
        let shippingDate = "2023-07-16";
        let country = "Korea";
        let zipCode = "12345";
        let addressName = "대전 중구 오류동";

        // form 요소에 값을 자동으로 채움
        document.querySelector('input[name="name"]').value = name;
        document.querySelector('input[name="shippingDate"]').value = shippingDate;
        document.querySelector('input[name="country"]').value = country;
        document.querySelector('input[name="zipCode"]').value = zipCode;
        document.querySelector('input[name="addressName"]').value = addressName;
    }
</script>
</body>
</html>