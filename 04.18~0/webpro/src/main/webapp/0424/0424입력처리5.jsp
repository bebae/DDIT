<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <style>
        h1 {
            color: red;
        }
        table {
            text-align: center;
            border: 1px solid blue;
            width: 600px;
            height: 300px;
        }
    </style>
</head>
<body>
    <h1>JSP : Java Server Page</h1>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	
    	String userId = request.getParameter("id");
    	String userTel = request.getParameter("tel");    	
    	String userMail = request.getParameter("mail");	
    	String userArea = request.getParameter("area");
    	
    	String scar = request.getParameter("carsingle");
    	String[] mcar = request.getParameterValues("carmulti");
    	
    	String str = "";
    	for(String car : mcar){
    		str += car+"&nbsp;&nbsp;";
    	}
    	
    	// userArea 값에는 엔터기호가 포함되서 \n을 <br>로 변환
    	String area = userArea.replaceAll("\n", "<br>");
    	
    	
    %>
    <table border="1">
        <tr>
            <td>이름</td>
            <td><%= userId %></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><%= userTel %></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><%= userMail %></td>
        </tr>
        <tr>
            <td>고객의 소리</td>
            <td><%= area %></td>
        </tr>
        <tr>
            <td>자동차</td>
            <td><%= scar %></td>
        </tr>
        <tr>
            <td>자동차</td>
            <td><%= str %></td>
        </tr>
    </table>
    
</body>
</html>
