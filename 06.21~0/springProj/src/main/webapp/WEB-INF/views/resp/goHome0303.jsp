<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>

<h2>home0303</h2>

<div>
  <button id="home030301">home030301</button>
  <button id="home030302">home030302</button>
</div>
<div>

</div>

<script type="text/javascript">
  $(function() {
      $("#home030301").click(function(){
          $.ajax({
              url : "/resp/goHome030101",
              type : "get",
              dataType : "json",
              success : function (response) {
                  console.log(response);
                  console.log("JSON : "+ JSON.stringify(response));
              }
          });
      });
      $("#home030302").click(function(){
          $.ajax({
              url : "/resp/goHome030302?bookId=1",
              contentType : "application/json;charset=UTF-8",
              type : "get",
              dataType : "json",
              success : function (response) {
                  console.log("JSON : "+ JSON.stringify(response));
              }
          });
      });
      $("#home030105").click(function(){
          $.ajax({
              url : "/resp/goHome030105?bookId",
              contentType : "application/json;charset=UTF-8",
              type : "get",
              dataType : "json",
              success : function (response) {
                  console.log("JSON : "+ JSON.stringify(response));
              }
          });
      });
  })
</script>