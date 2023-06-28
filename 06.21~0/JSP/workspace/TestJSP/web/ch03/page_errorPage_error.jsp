<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>서비스 문제 발생</title>
    <style>
        .error {
            font-size: 20px;
        }
    </style>    
</head>
<body>
    <div>
    </div>
        <!-- /image : root(webapp) > images 폴더 -->
        <img src="/images/error.jpg" alt="error.jsp"><br>
        <pre class="error">
        <%
            // exception 내장 객체(isErrorPage="true"일 때 활성화)
            exception.printStackTrace(new PrintWriter(out));
        %>
        </pre>
        
    </div>

</body>
</html>