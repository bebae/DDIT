<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>
<body>

<%--
    파일 업로드를 위한 method 속성 값은 post,
    enctype 속성 값은 multipart/form-data,
    업로드된 파일을 어리하기 위한 action 속성 값을 작성
    <input type="file" name=""...
--%>
    <form action="<%=request.getContextPath()%>/ch07/fileupload03_process.jsp" method="post" enctype="multipart/form-data">
        <!-- 파일을 입력받도록 input 태그의 type 속성 값을 file로 작성하고, name 속성을 작성함 -->
        <p>파일 : <input type="file" name="filename" /></p>
        <!-- 입력된 데이터를 서버로 전송하도록 input 태그의 type 속성 값을 submit으로 작성 -->
        <p><input type="submit" value="파일 올리기" /></p>

    </form>


</body>
</html>