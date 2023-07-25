<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>북 관리 시스템</title>
</head>
<body>
  <h1>책 목록</h1>

  <div>
    <!-- action 속성 및 값 생략 시, 현재 URI(/list) 재요청 / method는 생략 시 GET -->
    <form>
      <input type="text" name="keyword" value="${param.keyword}" placeholder="검색어를 입력해주세요.">
      <button type="submit"> 검색</button>
    </form>
  </div>
  <br>

  <table>
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>카테고리</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
    <!-- foreach 여러개의 값이 저장되어 있는 데이터를 순차적으로 처리 -->
    <c:forEach var="bookVO" items="${list}" varStatus="stat">
      <tr>
        <td>${stat.count}</td>
        <td><a href="/detail?bookId=${bookVO.bookId}">${bookVO.title}</a></td>
        <td>${bookVO.category}</td>
        <td><fmt:formatNumber type="number" value="${bookVO.price}" pattern="#,###" /></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</body>
</html>
