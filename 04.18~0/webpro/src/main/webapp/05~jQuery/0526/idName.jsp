<%@page import="kr.or.ddit.buyer.vo.BuyerVo"%>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%
    // 서블릿에서 저장한 결과를 꺼내기
    // request 객체로 저장하고 보낸 객체이름을 get
    List<BuyerVo> buyerList = (List<BuyerVo>)request.getAttribute("requestVoList");

	%>
	[
	<%
	    for (int i = 0; i < buyerList.size(); i++) {	
	    	BuyerVo vo = buyerList.get(i);
	        if (i > 0) out.println(",");
	%>
	    {
	        "id": "<%=vo.getBuyer_id()%>",
	        "name": "<%=vo.getBuyer_name()%>"
	    }
	<%
	    }
	%>
	]
