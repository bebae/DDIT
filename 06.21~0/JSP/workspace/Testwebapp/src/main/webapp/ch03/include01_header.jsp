<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%! // 선언문 전역변수
    int pageCount = 0;

    void addCount() {
        pageCount++;
    }
%>
<% // 스크립틀릿
 addCount(); // 전역 메소드 호출
%>
<p>이 사이트의 방문은 <%=pageCount%>번째 입니다.</p>
