<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Security</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            height: 100vh;
            background-color: #f2f2f2;
        }

        .login-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            padding: 10px;
            margin-bottom: 10px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .login-form button[type="submit"] {
            padding: 10px 20px;
            background-color: #6495ED;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .login-form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            text-align: left;
        }
    </style>
</head>
<body>
    <div>
        <form name="loginForm" action="j_security_check" method="post">
        <p>ID : <input type="text" name="j_username"></p>
        <p>비밀번호 : <input type="password" name="j_password"></p>
        <p><button type="submit">로그인</button></p>
        </form>
    </div>
</body>
</html>