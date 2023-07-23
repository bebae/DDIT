<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%
  String productId = request.getParameter("cartId");


  if (productId == null || productId.isEmpty()) { // 상품 id가 담긴 파라미터 안 확인
      response.sendRedirect("/products.jsp");
      return;
  }

  ProductRepository dao = ProductRepository.getInstance();
  ProductVO productVO = dao.getProductById(productId);

  if (productVO == null) { // 상품이 없을 떄 이동
      response.sendRedirect(request.getContextPath()+ "/welcome/exceptionNoProductId.jsp");
      return;
  }

  List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");

//  장바구니에서 넘겨준 파라미터의 세션 안에 있는 ID를 찾아서 삭제하기
  // Iterator를 사용하여 요소 삭제
  Iterator<ProductVO> iterator = cartlist.iterator();
  while (iterator.hasNext()) {
    ProductVO vo = iterator.next();
    if (vo.getProductId().equals(productId)) {
      iterator.remove();  // 삭제
      break;  // 삭제 후 루프 종료
    }
  }


  response.sendRedirect(request.getContextPath() + "/welcome/cart.jsp");
%>



