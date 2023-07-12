<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  session.invalidate();

  // addProduct.jsp를 요청한다는 의미는
  // <role-name>admin</role-name> 롤을 갖고 있어야 함
  // login.jsp에서 로그인 하고 다시 요청하라는 의미
  response.sendRedirect("addProduct.jsp");

%>