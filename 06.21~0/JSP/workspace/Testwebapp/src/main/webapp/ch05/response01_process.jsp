<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    // 분기
    if (id.equals("a001") && pass.equals("123")){
        response.sendRedirect("response01_success.jsp");
    } else {
        response.sendRedirect("response01_failed.jsp");
    }
%>
