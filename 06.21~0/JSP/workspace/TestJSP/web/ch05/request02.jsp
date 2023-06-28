<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Implicit Objects(내장 객체)</title>
</head>
<body>
<!--
    요청 URL : process.jsp
    요청 파라미터 : {name=입력값}
-->
    <!--  폼 필드  -->
    <form action="<%=request.getContextPath()%>ch05/process02.jsp" method="post">
    <!--  폼 데이터  -->
        <p>
            이름 : <input type="text" name="id" placeholder="아이디를 입력해주세요" required />
        </p>
        <p>
            비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력해주세요" required />
        </p>
        <p><input type="submit" value="전송" /></p>
    </form>
</body>
</html>