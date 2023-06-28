<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inset title</title>
</head>
<body>
<%
// 모든 Headers의 이름을 가져오기 => 리턴타입 : Enumeration(열거형)
Enumeration en = request.getHeaderNames();
// hasMoreElements() : 값이 있을 때에만 반복
while (en.hasMoreElements()) {
    // 현재 Header name 을 가져옴(Object)
    String headerName = (String)en.nextElement();
    String headerValue = request.getHeader(headerName);
    out.print("<h3>" + headerName + " : " + headerValue + "</h3>");
}
%>
<p>요청 정보 길이 : <%=request.getContentLength()%></p>
<p>클라이언트 전송 방식 : <%=request.getMethod()%></p>
<p>요청 URI : <%=request.getRequestURI()%></p>
<p>서버 이름 : <%=request.getServerName()%></p>
<p>서버 포트 : <%=request.getServerPort()%></p>

</body>
</html>