<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkform(){
		console.log("개똥이");
		let id = document.loginForm.id.value;//a001
		let passwd = document.loginForm.passwd.value;//java
		console.log("id : " + id + ", passwd : " + passwd);
	}
</script>
</head>
<body>
<!-- body와 body 사이를 document라고 함 -->
	<form name="loginForm">
		<p>아이디 : <input type="text" name="id" /></p>
		<p>비밀번호 : <input type="password" name="passwd" /></p>
		<!-- checkform() : 핸들러함수  -->
		<p><input type="button" value="전송" onclick="checkform()" /></p>
	</form>
</body>
</html>