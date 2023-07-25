<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	// mav.addObjext("data", bookVO);
%>
<!DOCTYPE html>
<html>
<head>
	<title>책 상세</title>
	<script src="/resources/js/jquery-3.6.0.js"></script>
	<script src="/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
<h1>책 상세</h1>
<!--
  BookController에서 보내준 데이터를 뷰(jsp)에 표현하도록 도와줌
  BookkController에 mav.addObject("data", bookVO); 를 선언해서 사용

  method
  1) GET : 데이터를 변경하지 않을 때. 목록/상세보기
  2) POST : 데이터를 변경할 때. 입력/수정/삭제

 	-----SQL----
 	WHERE
 		1) 단일행 : =, <, >, <=, >=, !=, <>
 		2) 다중행 : IN(교집합), ANY(OR), ALL(AND), EXISTS(교집합)
-->
<form id="frm" name="frm" action="/updatePost" method="post">
	<!-- 폼데이터 -->
	<input type="hidden" name="bookId" value="${data.bookId}" />
	<p>제목 : <input type="text" class="formdata" name="title" value="${data.title}" readonly /></p>
	<p>카테고리 : <input type="text" class="formdata" name="category" value="${data.category}" readonly /></p>
	<p>가격 : <input type="text" class="formdata" name="price" maxlength="10"
								 value='<fmt:formatNumber type="number" value="${data.price}" pattern="#,###" />' readonly /></p>
	<p>설명 : <textarea rows="5" cols="30" class="formdata" name="content" readonly>${data.content}</textarea>
		<!-- 일반 모드 시작 -->
	<p id="p1">
		<input type="button" id="edit" value="수정" />
		<input type="button" id="delete" value="삭제" />
		<input type="button" id="list" value="목록" />
	</p>
	<!-- 일반모드 끝 -->
	<!-- 수정모드 시작 -->
	<p id="p2" style="display: none">
		<input type="submit" id="confirm" value="확인" />
		<input type="button" id="cancel" value="취소" />
	</p>
	<!-- 수정 모드 끝 -->
</form>

<script type="text/javascript">
	$(function(){
		console.log("제이쿼리 확인");

		$("#list").click(function (){
			location.href = "/list";
		});

		// 수정 버튼을 누르면 -> 수정 모드
		$("#edit").on("click", function (){
			$("#p1").css("display","none");
			$("#p2").css("display","block");
			$(".formdata").removeAttr("readonly");

			// 가격 요소를 선택 후
			let objPrice = $("input[name='price']");
			let price = objPrice.val();
			price = price.replaceAll(",","");
			objPrice.val(price);
			objPrice.attr("type", "number");

			// CKEditor를 생성할 때 autoParagraph 옵션을 false로 설정
			CKEDITOR.replace("content", {
				autoParagraph: false
			});


			$("#frm").attr("action","/updatePost");
		});

		// 취소 버튼 클릭
		$("#cancel").on("click", function (){
			//  주소표시줄 : /detail?bookId=1
			// param : bookId=1 => param.bookID : 1
			location.href="/detail?bookId=${param.bookId}";
		});

		// 삭제 버튼
		$("#delete").on("click", function (){
			$("#frm").attr("action","/deletePost");

			let result = confirm("정말로 삭제하시겠습니까?");

			if(result > 0) {
				$("#frm").submit();
			} else {
				alert("삭제가 취소되었습니다.");
			}
		});

	});
</script>
</body>
</html>
