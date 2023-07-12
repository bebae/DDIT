<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script type="text/javascript">
	function checkLogin(){
		let form = document.loginForm; //폼
		//아이디 : 4~12자 사이로 입력
		if(form.id.value.length<4||form.id.value.length>12){
			alert("아이디는 4~12자 이내로 입력 가능합니다.");
			form.id.select();	//focus()        //커서 이동 
			return; //false 생략 가능. 함수 종료.
		} 
		//비밀번호 : 4자 이상으로 입력
		//else if를 안 쓴 이유? 모두 통과 하므로 
		if(form.passwd.value.length<4){ //해당 문서 내의 요소(element)의 name 속성 값을 찾음
			alert("비밀번호는 4자 이상으로 입력해야 합니다.");
			form.passwd.select();//커서를 위치함
			return;
		} 
		//모두 통과했다면
		form.submit();	//validation03_process.jsp를 요청
	}
</script>
</head>
<body>
<!-- body와 body 사이를 document라고 함 -->
	<!-- 요청URL : validation03_process.jsp
		  요청파라미터 : {id=a001,passwd=java}
		  요청방식 : post 
	 -->
	<form name="loginForm" action="validation03_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id" /></p>
		<p>비밀번호 : <input type="password" name="passwd" /></p>
		<!-- checkLogin() : 핸들러함수  -->
		<p><input type="button" value="전송" onclick="checkLogin()" /></p>
	</form>
</body>
</html>

<!-- 

select()와 focus()는 JavaScript에서 사용되는 두 가지 다른 메서드입니다. 
이 두 메서드는 다음과 같은 기능을 수행합니다.

select() 메서드:

select() 메서드는 텍스트 입력 필드(<input> 또는 <textarea>)에 사용됩니다.
해당 필드 내의 텍스트를 선택(하이라이트)합니다. 선택된 텍스트는 사용자가 즉시 수정하거나 복사할 수 있도록 합니다.
예를 들어, element.select()와 같이 요소의 select() 메서드를 호출하면 해당 요소 내의 텍스트가 선택됩니다.

focus() 메서드:

focus() 메서드는 특정 요소에 포커스를 설정합니다.
포커스는 사용자 입력을 받을 수 있는 요소에 대한 활성화 상태를 나타냅니다. 포커스가 있는 요소는 사용자가 키보드 입력을 직접 수행할 수 있습니다.
예를 들어, element.focus()와 같이 요소의 focus() 메서드를 호출하면 해당 요소에 포커스가 설정됩니다.

요약하면, select() 메서드는 텍스트를 선택(하이라이트)하는 데 사용되고, focus() 메서드는 특정 요소에 포커스를 설정하는 데 사용됩니다. 
두 메서드는 다른 목적과 사용 시기를 가지고 있으며, 특정 상황에 따라 각각 필요한 메서드를 사용해야 합니다.
 -->