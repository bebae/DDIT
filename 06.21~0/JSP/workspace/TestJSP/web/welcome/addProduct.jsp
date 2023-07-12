<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
    <title>상품 등록</title>
    <!-- WYSIWYG (What You See Is What You Get)(=당신이 보는 것 그대로 들어간다) -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
</head>
<body>
<%--    <fmt:setLocale value='<%=request.getParameter("language")%>' />--%>
    <fmt:setLocale value="${param.language}" />
    <fmt:bundle basename="bundle.message">
    <jsp:include page="/welcome/menu.jsp" />

    <%--  상품 등록 시작  --%>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><fmt:message key="title" /></h1>
        </div>
    </div>

    <div class="container">
        <div class="text-right">
            <a href="?language=ko">Korean</a> | <a href="?language=en">English</a>
            <!-- 로그아웃 페이지 호출 -->
            <a href="<%=request.getContextPath()%>/welcome/logout.jsp" class="btn btn-sm btn-success -pull-right ml-3">Logout</a>
        </div>
        <!-- 폼 필드
        요청 URL : processAddProduct.jsp
        요청방식 : post
        요청 파라미터 : HTTP 파라미터, QueryString :
            {productId=P1237, pname=에어팟3, unitPrice=200000, description=상세정보,
            manufacturer=Apple, category=Tablet, unitsInStock=1000, condition=Old}
        -->
        <form action="<%=request.getContextPath()%>/welcome/processAddProduct.jsp"
              name="newProduct" method="post" target="_blank" class="form-horizontal">
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="productId" /></label>
                <label class="col-sm-3">
                    <input type="text" name="productId" id="productId" class="form-control" required />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="pname" /></label>
                <label class="col-sm-3">
                    <input type="text" name="pname" id="pname" class="form-control" required />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="unitPrice" /></label>
                <label class="col-sm-3">
                    <input type="text" name="unitPrice" id="unitPrice" class="form-control" required />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="description" /></label>
                <label class="col-sm-3">
                    <textarea rows="3" cols="50" name="description" id="description" class="form-control"></textarea>
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="manufacturer" /></label>
                <label class="col-sm-3">
                    <input type="text" name="manufacturer" id="manufacturer" class="form-control" />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="category" /></label>
                <label class="col-sm-3">
                    <input type="text" name="category" id="category" class="form-control" />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="unitsInStock" /></label>
                <label class="col-sm-3">
                    <input type="text" name="unitsInStock" id="unitsInStock" class="form-control" />
                </label>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 h3"><fmt:message key="condition" /></label>
                <div class="col-sm-4">
                    <input type="radio" name="condition" id="condition1" class="" value="New" />
                    <label for="condition1"><fmt:message key="condition_New" /></label>
                    <input type="radio" name="condition" id="condition2"  class="ml-3" value="Old" />
                    <label for="condition2"><fmt:message key="condition_Old" /></label>
                    <input type="radio" name="condition" id="condition3" class="ml-3" value="Refurbished" />
                    <label for="condition3"><fmt:message key="condition_Refurbished" /></label>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" value="<fmt:message key="button" />" class="btn btn-primary px-lg-5" />
                </div>
            </div>
        </form>
    </div>

    <jsp:include page="/welcome/footer.jsp" />
    </fmt:bundle>

<script type="text/javascript">
    CKEDITOR.replace("description");
</script>
</body>
</html>