<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--
  로그인 실패 시 실행
  1. 사용자 로그인 실패(인증 싪)
    -> loing.jsp 로 강제 이동
  2. 로그인은 되지만 권한 없음(인가 실패)
    -> 403 오류
--%>
<%
  // 요청 파라미터 : error=1
  response.sendRedirect(request.getContextPath() + "/welcome/login.jsp?error=1");
%>
<%-- 인텔리 제이에는 2개가 기본 --%>
<%-- FIXME : 오작동 코드 --%>
<%-- TODO : 해야되는 작업 --%>
<%--  - 멀티 라인 가능  --%>