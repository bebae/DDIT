%@ page import="java.util.Enumeration" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  request.setCharacterEncoding("UTF-8");

  Cookie[] cookies = new Cookie[6];
  int cnt = 0;

  String[] paramNames = { "cartId", "name", "shippingDate", "country", "zipCode", "addressName" };

  for (String paramName : paramNames) {
    String paramValue = request.getParameter(paramName);

    out.println("paramName: " + paramName + "<br>");

    cookies[cnt] = new Cookie("shipping_" + paramName, URLEncoder.encode(paramValue, "UTF-8"));
    cookies[cnt].setMaxAge(24 * 60 * 60);

    response.addCookie(cookies[cnt++]);
  }

  out.println("------------------------------------------");
  response.sendRedirect("orderConfirmation.jsp");
%>
<a href="<%=request.getContextPath()%>/ch14/cookie02.jsp">[테스트]쿠키 확인하기</a>


