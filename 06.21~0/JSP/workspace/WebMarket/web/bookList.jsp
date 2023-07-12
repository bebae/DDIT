<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="dao.BookDAO" %>
<%@ page import="vo.BookVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>InsertTitle</title>
</head>
<body>
<%
    BookDAO dao =BookDAO.getInstance();
    List<BookVO> list = dao.getAllBooks();
%>
<c:set var="list" value="<%=list%>" />

<%@ include file="./menu.jsp" %>

    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">도서 목록</h1>
        </div>
    </div>

    <div class="container">
        <c:forEach var="vo" items="${list}" varStatus="stat">
            <c:if test="${stat.index>0}">
            <hr />
            </c:if>
        <div class="container">
            <div class="row">
                <h4>${vo.name}</h4>
            </div>
            <div class="row">
                <div class="col">
                    <p>${vo.description}</p>
                </div>
                <div class="col-2">
                    <a href="<%=request.getContextPath()%>/bookDetail.jsp?bookId=${vo.bookId}" class="btn btn-secondary">상품 목록&nbsp;&raquo;</a>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <p>${vo.author} | ${vo.publisher} | ${vo.unitPrice}원</p>
                </div>
            </div>

        </div>

        </c:forEach>
    </div>

<%@ include file="./footer.jsp" %>

</body>
</html>