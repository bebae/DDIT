<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scripting Tag</title>
</head>
<body>

<h2>Scripting Tag</h2>

<!-- 선언문 : 변수, 메소드 -->
<%!
    // 전역 변수 초기화
    int count = 3;

    // 전역 메소드
    // String : 리턴타입, date : 파라미터(인수)타입 매개변수
    String makeItLower(String date) {
        return date.toLowerCase();
    }
%>
<%  // 스크립틀릿 태그(자바 로직 코드 작성)
    // 지역 변수 i를 사용하고 1부터 3까지 1씩 증가
    for (int i=1; i<= count; i++) {
        // out : JSP 내장 객체
        out.println("Java Server Pages "+i+".<br>");
    }
%>


<h3><%=count%></h3>


<script type="text/javascript">

</script>
</body>
</html>