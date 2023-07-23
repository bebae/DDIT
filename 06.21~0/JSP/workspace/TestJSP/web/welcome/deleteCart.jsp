<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String cartId = request.getParameter("cartId");

  if (cartId != null){ // 만약 cartId가 있다면 세션 삭제
    // 장바구니만 비우기
    session.removeAttribute("cartlist");
  }

  response.sendRedirect(request.getContextPath() + "/welcome/cart.jsp");
%>
