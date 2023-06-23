<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
    <title>Directuce Tag</title>
</head>
<body>
    <% 
    String memId = "김민수"; 
    memId = URLEncoder.encode(memId, "UTF-8");
    %>
    <!-- header 인클루드 -->
    <%@ include file="/ch03/include01_header.jsp" %>
    <h4>--------- 현재 페이지 영역 ---------</h4>
    <!-- footer 인클루드 -->
    <!-- JSP 내장객체인 request객체에 담김
        include 디렉티브는 요청파라미터를 전달할 수 없음 -->
    <!-- <% // include file="/ch03/include01_footer.jsp?memId="+memId %> -->
    <!-- 요청 URL : include01_footer.jsp
         요청 파라미터 : memId = 김민수
         요청 URI : include01_footer.jsp?memId=김민수 -->
    <jsp:include page="/ch03/include01_footer.jsp">
        <jsp:param value="<%=memId%>" name="memId"/>
    </jsp:include>

</body>
</html>