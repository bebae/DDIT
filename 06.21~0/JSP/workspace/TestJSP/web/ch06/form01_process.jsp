<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Arrays" %>
<%--
  요청 URL : form01_process.jsp
  요청 방식 : post
  요청 파라미터(HTTP 파라미터 = QueryString) :
  { id, pass, name, phone1, phone2, phone3, gender, hobby, comment }
--%>
<%  // 스크립틀릿
  request.setCharacterEncoding("UTF-8");

  // 모든 파라미터 타입 : String
  String id = request.getParameter("id");
  String pass = request.getParameter("pass");
  String name = request.getParameter("name");
  String phone1 = request.getParameter("phone1");
  String phone2 = request.getParameter("phone2");
  String phone3 = request.getParameter("phone3");
  String gender = request.getParameter("gender");
  String[] hobbies = request.getParameterValues("hobby");
  String comment = request.getParameter("comment");
  out.println("gender = " + gender);
%>

  <label for="id">아이디:</label>
  <input type="text" name="id" id="id" value="<%= id %>" readonly /><br><br>

  <label for="pass">비밀번호:</label>
  <input type="password" name="pass" id="pass" value="<%= pass %>" readonly /><br><br>

  <label for="name">이름:</label>
  <input type="text" name="name" id="name" value="<%= name %>" readonly /><br><br>

  <label for="phone1">연락처:</label>
  <select name="phone1" id="phone1" disabled>
    <option value="010" <%= phone1.equals("010") ? "selected" : "" %>>010</option>
    <option value="011" <%= phone1.equals("011") ? "selected" : "" %>>011</option>
    <option value="016" <%= phone1.equals("016") ? "selected" : "" %>>016</option>
    <option value="017" <%= phone1.equals("017") ? "selected" : "" %>>017</option>
    <option value="019" <%= phone1.equals("019") ? "selected" : "" %>>019</option>
  </select>
  <label for="phone2">-</label>
  <input type="text" name="phone2" id="phone2" maxlength="4" size="4" pattern="[0-9]*" value="<%= phone2 %>" readonly />
  <label for="phone3">-</label>
  <input type="text" name="phone3" id="phone3" maxlength="4" size="4" pattern="[0-9]*" value="<%= phone3 %>" readonly /><br><br>

  <label>성별:</label>
  <input type="radio" name="gender" id="male" <%= gender.equals("male") ? "checked" : "" %> disabled />
  <label for="male">남성</label>
  <input type="radio" name="gender" id="female" <%= gender.equals("female") ? "checked" : "" %> disabled />
  <label for="female">여성</label><br><br>

  <label for="hobby">취미:</label>
  <input type="text" name="hobby" id="hobby" value="<%= Arrays.toString(hobbies) %>" readonly /><br><br>

  <label for="comment">가입인사:</label><br><br>
  <textarea name="comment" id="comment" cols="30" rows="3" readonly><%= comment %></textarea><br><br>

  <input type="submit" value="가입하기" disabled />
  <input type="reset" value="다시쓰기" disabled /><br><br>
