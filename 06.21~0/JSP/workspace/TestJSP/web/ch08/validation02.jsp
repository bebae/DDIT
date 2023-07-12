<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	//핸들러함수
	function checkLogin(){
		let form = document.loginForm; //form태그를 object로 통으로 들어옴
		if(form.id.value==""){
			alert("아이디를 입력해주세요");
			form.id.focus(); //해당 입력 항목에 커서가 위치함
			return false; //함수 멈춤 (더이상 밑으로 내려가지 않음)
		}else if(form.passwd.value==""){
			alert("비밀번호를 입력해주세요");
			form.passwd.focus(); //커서를 위치함
			return false; //여기서 멈춰
		}
		//위의 분기문을 잘 통과했다면..
		form.submit(); //validation02_process.jsp를 요청 
	}
</script>
</head>
<body>
<!-- body와 body 사이를 document라고 함 -->
	<!-- 요청URL : validation02_process.jsp
		  요청파라미터(HTTP파라미터, QueryString) : {id=a001, passwd=java}
		  요청방식 : post 
	 -->
	<form name="loginForm" action="validation02_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id" /></p>
		<p>비밀번호 : <input type="password" name="passwd" /></p>
		<!-- checkLogin() : 핸들러함수  -->
		<p><input type="button" value="전송" onclick="checkLogin()" /></p>
	</form>
</body>
</html>