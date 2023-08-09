<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>

<h3>register</h3>

<div>

  <form action="/board/post" method="post">
    <label>
      <input type="text" value="ISBN1234" name="bookId">
    </label>
    <button type="submit" name="register">Register</button>
    <button type="submit" name="update">Update</button>
    <button type="submit" name="delete">Delete</button>
    <button type="submit" name="list">List</button>
    <br><hr>
    <button type="reset"><a href="/board/get?remove">GetRemove</a></button>
    <button type="submit" name="remove">PostRemove</button>
    <button type="reset"><a href="/board/get?read">Read</a></button>
    <br><hr>
    <button type="button" name="remove" id="btnHeaders">Headers매핑</button>
  </form>
</div>

<script type="text/javascript">
  $(function(){
    $("#btnHeaders").on("click", function() {
      let boardNo = "10";
      let title = "멋진 이름";
      let content = "재미있는 내용";
      let writer = "유명 작가";

      let data = {"boardNo" : boardNo, "title" : title,
          "content" : content, "writer" : writer};
      // JSON object -> string으로 변환
      // JSON : JavaScript Object Notation(표기법)
      console.log("data : " + JSON.stringify(data) )

      $.ajax({
          url : "/board/"+boardNo,
          contentType : "application/json; charset=UTF-8",
          data : JSON.stringify(data),
          type : "post",
          success : function (result){
              console.log("data : " + result)
          }
      })

    });
  })
</script>