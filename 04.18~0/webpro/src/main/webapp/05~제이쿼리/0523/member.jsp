<%@page import="kr.or.ddit.member.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 전송 데이터 받기
	
	// DB처리
	SqlSession sqlSession = null;	// html 자체에 session 변수가 이미 정의되어 있음
    List<MemberVo> memberList; // 반환할 리스트 객체 생성
    try {
    	sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        memberList = sqlSession.selectList("member.getAllMember");
  
 %>
 	<table border="1">
 		<tr>
 			<td>아이디</td>
 			<td>이름</td>
 			<td>전화번호</td>
 			<td>주소</td>
 		</tr>
 <%
   	// 결과값 출력
   	for (int i=0; i<memberList.size();i++){
   		MemberVo vo = memberList.get(i);
 %>
 		<!-- jsp -->
 		<tr>
 			<td><%= vo.getMem_id() %></td>
 			<td><%= vo.getMem_name() %></td>
 			<td><%= vo.getMem_tel() %></td>
 			<td><%= vo.getMem_addr() %></td>
 		</tr>
 <% } 
   	
    } finally {
        if(sqlSession != null) sqlSession.close();
    }

%>
	</table>

</body>
</html>