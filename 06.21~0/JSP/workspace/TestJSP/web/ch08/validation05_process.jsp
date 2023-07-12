<%@ page language="java" contentType="text/html; charset=UTF-8"%> <!-- 첫번째 줄에 있어야 가독성, 통일성 있음 (위치 중요하진 않음) -->
<%@ page import="vo.UsersVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//요청URL : validation05_process.jsp
//요청파라미터 : {id=a001,passwd=1234,name=개똥이,phone1=010,phone2=1234,phone3=2211,
//				email=test@test.co.kr}
//요청방식 : post
request.setCharacterEncoding("UTF-8");

String id     = request.getParameter("id"); //큰따옴표("") 안에 공백도 인식해!! 
String name   = request.getParameter("name");
String passwd = request.getParameter("passwd");
String phone  = request.getParameter("phone");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String email  = request.getParameter("email");

//UsersVO usersVO = new UsersVO();
UsersVO usersVO = new UsersVO(phone1,phone2,phone3); //이걸 넣으면 객체 생성할 때  값들어가는거야?
usersVO.setId(id);
usersVO.setPasswd(passwd);
usersVO.setName(name);
//usersVO.setPhones(phone1,phone2,phone3); //기본생성자 쓰면 안돼? usersVO(phone1,phone2,phone3); 그거랑 뭐가 달라?
usersVO.setEmail(email);

out.print("usersVO : " + usersVO);//toString()메소드 안쓰면 글자로 안보임
%>
<c:set var="usersVO" value="<%=usersVO%>"/> <!-- foreach쓸 때는 V I V 쓰기 --> <!-- 자바변수를 jstl 변수로 바꾸기 -->
<p>아이디 :  ${usersVO.id} </p>
<p>비밀번호 :${usersVO.passwd}  </p>
<p>이름 :    ${usersVO.name}</p>
<p>연락처 :  ${usersVO.phone} </p>
<p>이메일 :  ${usersVO.email} </p>