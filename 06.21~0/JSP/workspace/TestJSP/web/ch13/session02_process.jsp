<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Session</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");

  String user_id = request.getParameter("id");
  String passwd = request.getParameter("passwd");

  out.println("session 고유아이디(웹 브라우저 당 1개) : "+ session.getId()+"<br/>");
  if (user_id.equals("admin") && passwd.equals("123")) {
      HttpSession httpSession = request.getSession();
      // 동일한 웹브라우저 내 정보 공유

      httpSession.setAttribute("userId", user_id);
      httpSession.setAttribute("userPw", passwd);
      out.print("<p>세션 설정 성공</p>");;
      out.println("<p>"+ user_id + "님 환영합니다.</p>");
      out.println("<a href='session01.jsp'>되돌아가기</a>");
  } else {
    out.print("<p>세션 설정 실패</p>");;
    out.println("<a href='session01.jsp'>되돌아가기</a>");
  }
%>
<div>

</div>
</body>
</html>
