function CheckAddProduct(){ //(유효성검사(Validation) 핸들러함수) 
	let form = document.newProduct;
	
	//1) 상품 아이디 체크
	//첫 글자는 P. 숫자를 조합하여  5~12자까지 입력 가능
	// P1234
	let regExpId = /^P[0-9]{4,11}/; //P빼고 4번이상 11번이하 반복 
	if(!regExpId.test(form.productId.value)){
		alert("[상품 코드]\nP와 숫자를 조합하여 5~12자까지 입력하세요\n첫 글자는 P로 시작하세요");
		form.productId.select();
		form.productId.focus();
		return false; //이벤트 핸들러에서 return false;를 사용하면 해당 이벤트를 취소하고 기본 동작을 막습니다. 예를 들어, 폼 제출 이벤트에서 return false;를 사용하면 폼이 제출되지 않고 페이지가 새로고침되지 않습니다.
	}
	
	//2) 상품명 체크
	//4~12자까지 입력 가능
	// ex) 삼성갤럭시S22
	if(form.pname.value.length<4||form.pname.value.length>12){
		alert("[상품명]\n최소 4자에서 최대 12자까지 입력하세요");
		form.pname.select();//입력한 값 선택
		form.pname.focus();//입력 필드로 커서 이동(깜빡깜빡)
		return false; //함수 멈춰
	}
	
	//3) 상품 가격 체크
	//숫자만 입력 가능. 음수는 막자
	if(form.unitPrice.value.length==0||isNaN(form.unitPrice.value)){//길이가 0이거나(입력안함), 숫자가 아니면
		alert("[가격]\n숫자만 입력하세요");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
	
	if(form.unitPrice.value<0){//0보다 작으면(음수면)
		alert("[가격]\n음수는 입력할 수 없습니다.");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
	
	//1243214.12 소수점 둘째자리까지만 허용
	// /^\d+((\.)?([0-9]{1,2})?)?$/;
//	let regExpUnitPrice = /^\d+(?:[.]?[\d]?[\d])?$/; //첫글자가 숫자고, 1개 이상 (^[0-9]+)          [0-9] = \d (숫자)   // ?:[] (있어도 그만 없어도 그만 (? 앞에다 쓸 때 ))
	let regExpUnitPrice = /^\d+$/; 
			if(!regExpUnitPrice.test(form.unitPrice.value)){
		alert("[가격]\n가격은 소수점 둘째자리까지만 허용됩니다.");
		form.unitPrice.select();
		form.unitPrice.focus();
		return false;
	}
			
	//4) 재고 수 체크
	//숫자만 입력 가능
	if(form.unitsInStock.value.length==0||isNaN(form.unitsInStock.value)){ //숫자가 아니라면
		alert("[재고수]\n숫자만 입력해주세요");
		form.unitsInStock.select();
		form.unitsInStock.focus();
		return false;
	}
	
	//유효성검사를 모두 통과했다면 
//	alert("모두 통과!!");
 	form.submit();
}