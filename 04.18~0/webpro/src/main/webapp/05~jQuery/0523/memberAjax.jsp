<%@ page import="kr.or.ddit.member.vo.MemberVo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%
	SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
	List<MemberVo> memberList = sqlSession.selectList("member.getAllMember");
	%>
	[
	<%
	    for (int i = 0; i < memberList.size(); i++) {
	        MemberVo vo = memberList.get(i);
	        if (i > 0) out.println(",");
	%>
	    {
	        "id": "<%=vo.getMem_id()%>",
	        "name": "<%=vo.getMem_name()%>",
	        "tel": "<%=vo.getMem_tel()%>",
	        "addr": "<%=vo.getMem_addr()%>"
	    }
	<%
	    }
	%>
	]
