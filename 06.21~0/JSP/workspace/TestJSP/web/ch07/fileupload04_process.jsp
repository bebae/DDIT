<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<% //스크립틀릿
	//폼 페이지에서 전송된 파일을 저장할 서버의 경로를 작성
	String path = "c:\\upload"; 
	//Commons-Fileupload.jar를 이용
	//해당 패키지에 포함되어있음
	DiskFileUpload upload = new DiskFileUpload();
	//업로드 환경설정
	upload.setSizeMax(1000000); //=1Mb //업로드 가능 최대 크기(bytes-Kb->Mb->Gb) 
	upload.setSizeThreshold(4096); //메모리상에 저장할 최대 크기(bytes)              //주기억장치(메모리)
	upload.setRepositoryPath(path);//업로드될 파일을 임시로 저장할 경로(path 안쓰고 다른 경로 써놔도 됨(임시 저장))                                     //보조기억장치(하드디스크)
	//폼 페이지에서 전송된 multipart/form 유형의 요청파라미터->parseRequest()메소드로 전달받음
	List items = upload.parseRequest(request); //parse : 구문분석 (request객체를 구문 분석) 
	//Iterator 클래스로 변환
	Iterator params = items.iterator();
	//폼 페이지에서 전송된 요청 파라미터가 없을 때까지 반복
	while(params.hasNext()){
		//params.next()는 Object로 리턴
		FileItem item = (FileItem)params.next();
		//요청 파라미터가 일반 데이터인지
		if(item.isFormField()){//일반 데이터(<input type="text"..)
			String name = item.getFieldName();	//[name=개똥이]에서 name
			String value = item.getString("UTF-8");	//파라미터 값.[name=개똥이]에서 개똥이
			out.print("<p>" + name + "=" + value + "</p>");
		}else{//파일인지<input type="file"
			String fileFieldName = 
				item.getFieldName();	//요청 파라미터 이름[filename=파일객체]에서 filename
			String fileName = item.getName();	//저장 파일의 이름.P1237.jpg	
			String contentType = item.getContentType(); //MIME 타입. 콘텐츠 유형.
			//업로드 대상 => C:\\Users\\PC-24\\Pictures\\P1237.jpg
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1); //P1237.jpg   //마지막에 있는 "\\"를 찾아서 +1을 해서 첫번째 값부터 끝까지(시작점만 있으면 끝까지 선택) 자르기(substring)
			long fileSize = item.getSize();//파일 크기 정도    (최프 때 DB에 보통 관리 많이 함)
			//item(JSP) -> MultipartFile(Spring)
			//이곳으로 업로드 => c:\\upload\\P1237.jpg[설계]
			File file = new File(path + "/" + fileName);//(설계도 도면) 이 웹경로대로 쓰겠다.
			//설계대로 복사 실행
			item.write(file);
			
			out.print("<p>---------------</p>");
			out.print("<p>요청 파라미터 이름 : " + fileFieldName + "</p>");
			out.print("<p>저장 파일 이름 : " + fileName + "</p>");
			out.print("<p>파일 콘텐츠 타입 : " + contentType + "</p>");
			out.print("<p>파일 크기 : " + fileSize + "</p>");
		}
	}
%>