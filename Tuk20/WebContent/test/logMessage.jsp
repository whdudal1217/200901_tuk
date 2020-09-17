<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	application.log("application 로그 메세지 기록 ");
%>
application 로그 메세지를 기록합니다.
<!--  톰캣은 설치폴더 임테 logs란 폴더에 저장이 되는데 이클립스를 통해 톰캣을 실행하면 로그파일이 따로 생성되지 않음
	실무에선 서버에서 동작하기 때문에 해당 폴더나 다른 지정 폴더에 log파일이 매일매일 생성 됨
 -->
 <%
 	log("로그 메세지 기록2");
 %>
 로그 메세지2를 기록합니다.
</body>
</html>