<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List "%>
<%@ page import="vo.MemberVO"%>
<%
    List<MemberVO> memberVOList = new ArrayList<MemberVO>();
    MemberVO vo = new MemberVO();
    vo.setUsername("a001"); vo.setPassword("java"); vo.setEnabled("1");
    memberVOList.add(vo);
    vo = new MemberVO();
    vo.setUsername("b001"); vo.setPassword("java"); vo.setEnabled("1");
    memberVOList.add(vo);
    vo = new MemberVO();
    vo.setUsername("c001"); vo.setPassword("java"); vo.setEnabled("1");
    memberVOList.add(vo);
%>
<!DOCTYPE html>
<html>
<head>
    <title>InsertTitle</title>
</head>
<body>

    <table border="1">
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>사용여부</th>
        </tr>
        <%
        for (MemberVO memberVO : memberVOList){
            out.print("<tr>");
        	out.print("<td>"+memberVO.getUsername()+"</td>");
        	out.print("<td>"+memberVO.getPassword()+"</td>");
        	out.print("<td>"+memberVO.getEnabled()+"</td>");
            out.print("</tr>");
        }
        %>
    </table>

</body>
</html>