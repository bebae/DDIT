<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLDecoder"%>
<%
    request.setCharacterEncoding("UTF-8");
    String memId = request.getParameter("memId"); // 김민수
    memId = URLDecoder.decode(memId);
%>
<p>Copyright &copy;<%=memId%></p>
