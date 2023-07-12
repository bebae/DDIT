<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkForm(){
		//"1admin".substr(0,1) => 1
		//33개똥이     -> 이름 앞에 숫자가 들어가면 안됨
		//It is Not a Number : 그것은 숫자가 아니다(isNaN)가 아니다 => 숫자다
		let form = document.frm; //form
		if(!isNaN(form.name.value.substr(0,1))){
			//숫자라면
			alert("이름은 숫자로 시작할 수 없습니다.");
			form.name.select(); //focus()는 커서 이동, select는 그 문자 선택됨
			return;
		}
		//통과했다면
		form.submit(); //validation03_process.jsp를 요청 //form에 action없음=>현재URL을 요청, method없음=>기본get방식
	}
</script>
</head>
<body>
<!-- body와 body 사이를 document라고 함 -->
	<form name="frm">
		<p>이름 : <input type="text" name="name" /></p>
		<!-- checkform() : 핸들러함수  -->
		<p><input type="button" value="전송" onclick="checkForm()" /></p>
	</form>
</body>
</html>