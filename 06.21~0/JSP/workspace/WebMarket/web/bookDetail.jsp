<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.BookDAO" %>
<%@ page import="vo.BookVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
  // 싱글톤
  BookDAO dao = BookDAO.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <title>상품 상세 정보</title>
  <style>
      .container img {
          width: 100%;
          height: 300px;
      }
  </style>
</head>
<body>
<jsp:include page="./menu.jsp" />

<%--  상품 상세 시작  --%>
<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">도서 정보</h1>
  </div>
</div>
<%
  String bookId = request.getParameter("bookId");

  BookVO bookVO = dao.getBookById(bookId);
%>
<%-- 자바의 변수를 JSTL 변수로 가져오는 부분 --%>
<c:set var="vo" value="<%=bookVO%>" />
<%--  내용  --%>
<div class="container">
  <div class="row">
    <!-- 6크기의 1열 (컬럼=필드=속성=애트리뷰트) -->
    <div class="col">
      <h3>${vo.name}</h3>
      <p>${vo.description}</p>
      <p>
        <b>도서 코드 : </b>
        <span class="badge badge-secondary">${vo.bookId}</span>
      </p>
      <p><b>출판사 : </b>${vo.publisher}</p>
      <p><b>저자 : </b>${vo.author}</p>
      <p><b>재고수 : </b>${vo.unitsInStock}</p>
      <p><b>총 페이지수 : </b>${vo.totalPages}</p>
      <p><b>출판일 : </b>${vo.releaseDate}</p>
      <p class="h3">${vo.unitPrice}원</p>
      <p>
        <a href="<%=request.getContextPath()%>/#" class="btn btn-secondary">도서 주문&nbsp;&raquo;</a>
        <a href="<%=request.getContextPath()%>/bookList.jsp" class="btn btn-secondary">도서 목록&nbsp;&raquo;</a>
      </p>
    </div>
  </div>
</div>

<%--  상품 상세 끝  --%>

<%@ include file="./footer.jsp" %>
</body>
</html>