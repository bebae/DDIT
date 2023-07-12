<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navber-expand navbar-dark bg-dark">
    <!-- container : 내용이 들어갈 때 -->
    <div class="container">
        <a href="<%=request.getContextPath()%>/welcome.jsp" class="navbar-brand">Home</a>
        <a href="<%=request.getContextPath()%>/bookList.jsp" class="navbar-brand">List</a>
    </div>
</nav>