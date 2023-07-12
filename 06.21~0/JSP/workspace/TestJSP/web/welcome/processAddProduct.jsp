<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.ProductVO" %>
<%@ page import="dao.ProductRepository" %>
<%@ page import="java.util.List" %>
<!-- 폼 필드
요청 URL : processAddProduct.jsp
요청방식 : post
요청 파라미터 : HTTP 파라미터, QueryString :
{productId=P1237, pname=에어팟3, unitPrice=200000, description=상세정보,
manufacturer=Apple, category=Table, unitsInStock=1000, condition=Old}
-->
<% // 스크립틀릿
  // 폼 페이지에서 입력된 데이터를 서버로 전송 시 한글이 깨지니 않도록 문자 인코딩 유형을 UTF-8로 하여 request 내장 객체의 모든 파라미터를 인코딩 처리
  request.setCharacterEncoding("UTF-8");
  String productId = request.getParameter("productId");
  String pname = request.getParameter("pname");
  String unitPrice = request.getParameter("unitPrice");
  String description = request.getParameter("description");
  String manufacturer = request.getParameter("manufacturer");
  String category = request.getParameter("category");
  String unitsInStock = request.getParameter("unitsInStock");
  String condition = request.getParameter("condition");

  // 상품 가격
  int price = 0;
  // 폼 페이지에서 상품 가격이 입력되지 않을 경우 0으로, 입력된 경우 int 형으로 변경
  if (!unitPrice.isEmpty()) {
      price = Integer.parseInt(unitPrice);
  }

  // 재고 수
  int stock = 0;
  // 폼 페이지에서 상품 재고 수가 입력되지 않은 경우 0으로, 입력된 경우 int 형으로 변경
  if (!unitsInStock.isEmpty()) {
      stock = Integer.parseInt(unitsInStock);
  }

  // 넘어온 값을 VO 에 저장
  ProductVO productVO = new ProductVO();
  productVO.setProductId(productId);
  productVO.setPname(pname);
  productVO.setUnitPrice(price);
  productVO.setDescription(description);
  productVO.setManufacturer(manufacturer);
  productVO.setCategory(category);
  productVO.setUnitsInStock(stock);
  productVO.setCondition(condition);
  productVO.setFilename(productId+".jpg");

  ProductRepository dao = ProductRepository.getInstance();

  dao.addProduct(productVO);

  List<ProductVO> productVOList = dao.getAllProducts();

  for (ProductVO vo : productVOList) {
    out.print("<p>" + vo + "</p>");
  }

  // 목록으로 강제 이동. response 내장 객체의 sendRedirect()
  response.sendRedirect(request.getContextPath()+"/welcome/products.jsp");
%>