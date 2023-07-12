<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.DiskFileUpload" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="java.io.File" %>
<%

  // 파일 저장 경로 설정
  String fileUploadPath = "D:\\D_Other\\web\\uploadFiles";
  DiskFileUpload upload = new DiskFileUpload();

  // 웹 브라우저(크롬)가 전송한 multpart/form 유형의 요청 파라미터들을 가져옴
  List items = upload.parseRequest(request);
  // form 데이터를 다 params에 저장
  Iterator params = items.iterator();

  // 받아서 1개씩 읽을 때 파일(.jpg)인지 일반 데이터인지 구별해야 함
  while(params.hasNext()) {
      FileItem fileItem = (FileItem) params.next();
      if (!fileItem.isFormField()){
          String fileName = fileItem.getName();
          // 파일 이름
          fileName = fileName.substring(fileName.lastIndexOf('\\') + 1);

        File file = new File(fileUploadPath + "/" + fileName);

        fileItem.write(file);

      }
  }

%>

