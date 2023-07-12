<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>

<jsp:include page="/welcome/menu.jsp" />

<div class="container w-25 mb-lg-5">
    <div class="col-m-4 col-md-offset-4 mt-lg-5">
        <h3 class="form-signin-heading">Please Sign in</h3>
    </div>
    <%  // 스크립틀릿
        // 로그인 실패 시 요청 파라미터 : login.jsp?error=1
        String error = request.getParameter("error");
        if (error != null) {
          // 오류 메세지 출력
          out.print("<div class='alert alert-danger'>");
          out.print("아이디와 비밀번호를 확인해주세요");
          out.print("</div>");
        }
    %>

    <!-- web.xml 안에 <auth-method>FORM</auth-method> 설정, action = j_security_check를 쓰면 설정한 (로그인)페이지를 반드시 거쳐야함 -->
    <form action="j_security_check" class="form-signin" method="post">
        <!-- 아이디 입력 영역 : j_username 고정값 -->
        <div class="form-group">
            <label for="inputUserName" class="sr-only">User Name</label>
            <input type="text" name="j_username" id="inputUserName" class="form-control input-sm" placeholder="ID를 입력해주세요" required autofocus>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" class="form-control input-sm" name="j_password" id="inputPassword" placeholder="Password를 입력해주세요" required autofocus>
        </div>
        <button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
    </form>
</div>


<jsp:include page="/welcome/footer.jsp" />
</body>
</html>