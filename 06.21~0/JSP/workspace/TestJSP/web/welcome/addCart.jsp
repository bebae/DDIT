<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  // form : product.jsp
  // to   : post 방식

  String productId = request.getParameter("productId");

  out.println("productId : " + productId);

  // trim() : 공백제거
  if (productId == null || productId.trim().isEmpty()) {
      response.sendRedirect("products.jsp");
      return;
  }
  // 기본키인 P1234 코드의 상품 찾기
  ProductRepository dao = ProductRepository.getInstance();
  ProductVO product = dao.getProductById(productId);

  // 상품 결과가 없다면
  if (product == null) {
      response.sendRedirect("exceptionNoProductId.jsp");
  }

  // 상품이 있다면 장바구니 처리
  ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartlist");

  // 장바구니 세션이 없다면 생성
  if (list == null) {
      list = new ArrayList<ProductVO>();
      session.setAttribute("cartlist", list);
  }

  int cnt = 0;
  for (ProductVO vo : list) {
    if (vo.getProductId().equals(productId)) {
      cnt++;
      // 장바구니에 상품이 이미 들어있다면 상품 개수를 1 증가시킴
      vo.setQuantity(vo.getQuantity() + 1);
    }
  }

  // 상품코드가 DB에 있으면서 장바구니에는 상품이 없다면
  if(cnt == 0) {
      // quantity를 1로 처리
      Objects.requireNonNull(product).setQuantity(1);
      list.add(product);    // 장바구니에 P1234 상품에 넣기
  }

  // 장바구니 확인
  for (ProductVO vo : list) {
    out.print("VO : "+ vo +"<br><hr><br>");
  }

  // 상품 상세 페이지로 이동
  response.sendRedirect(request.getContextPath()+"/welcome/product.jsp?productId="+productId);

%>
