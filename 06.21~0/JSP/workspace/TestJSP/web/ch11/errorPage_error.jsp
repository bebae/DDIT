<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>Exception</title>
</head>
<body>
<div>
  <p>오류가 발생했습니다.</p>
<%--
  exception : JSP에서 제공해주는 오류 처리용 기본 내장 객체
  오류 이벤트의 toString()을 호출해서 간단한 오류 메시지 확인
 --%>
  <p>예외 유형 : <%=exception.toString()%></p>

<%-- 오류 메시지의 발생 근원지를 찾아 단계별로 오류 출력 --%>
<%-- <p> 단계별 오류 출력 : <%=exception.printStackTrace()%> --%>
  <p>오류 메시지 : <%=exception.getMessage()%></p>
  <p>예외 유형 : <%=exception.getClass().getName()%></p>

</div>
</body>
</html>