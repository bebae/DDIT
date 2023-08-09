<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>

<h2>home0101</h2>

<div>
  <button id="home0101">home0101</button>
  <button id="home0102">home0102</button>
  <button id="home0303">home0303</button>
  <button id="home030301">home030301</button>
  <button id="home030302">home030302</button>
</div>
<hr>
<div>
  <button id="home04">home04</button>
  <button id="home05">home05</button>
  <label for="sel1"></label>
  <select id="sel1">
    <option value="">미선택</option>
  </select>
</div>

<script type="text/javascript">
  $(function() {
      $("#home0101").click(function(){
          location.href = "/resp/goHome0101"
      });
      $("#home0102").click(function(){
          location.href = "/resp/goHome0102"
      });
      $("#home0303").click(function(){
          location.href = "/resp/goHome0303"
      });
      $("#home030301").click(function(){
          location.href = "/resp/goHome030101"
      });
      $("#home030302").click(function(){
          location.href = "/resp/goHome030102"
      });
      $("#home04").click(function(){
          $.get("/resp/goHome04", function(data) {
              console.log(data);
          });
      });
      $("#home05").click(function(){
          $.get("/resp/goHome05", function(data) {
              console.log(data);
          });
      });

      $.ajax({
          url : "/resp/goHome09",
          type : "get",
          dataType : "json",
          contentType : "application/json; charset=UTF-8",
          success : function(data) {
              console.log("data : " + JSON.stringify(data));

              let options = "";
              $.each(data, function (index, str){
                  options += `<option value='${str}'>${str}</option>`;
              });
              $("#sel1").append(options);
          }
      });
  })
</script>