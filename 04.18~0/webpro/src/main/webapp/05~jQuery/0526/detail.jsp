<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%
    // 서블릿에서 저장한 결과를 꺼내기
    // request 객체로 저장하고 보낸 객체이름을 get
    BuyerVo vo = (BuyerVo)request.getAttribute("requestVo");

	%>
	[

	    {
	        "id": "<%=vo.getBuyer_id()%>",
	        "lgu" : "<%=vo.getBuyer_lgu()%>"
	        "name": "<%=vo.getBuyer_name()%>"
	        "mail" : "<%=vo.getBuyer_mail()%>"
	        "bank" : "<%=vo.getBuyer_bank()%>"
	        "ctel" : "<%=vo.getBuyer_comtel()%>"
	        "bname" : "<%=vo.getBuyer_bankname()%>"
	        "bno" : "<%=vo.getBuyer_bankno()%>"
	        "add1" : "<%=vo.getBuyer_add1()%>"
	        "add2" : "<%=vo.getBuyer_add2()%>"
	    }
	]
