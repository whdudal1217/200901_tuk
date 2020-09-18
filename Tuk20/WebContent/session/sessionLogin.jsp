<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% String id = (String)request.getParameter("id"); %>
<% String pwd = (String)request.getParameter("pwd"); %>
<% if(id.equals(pwd)){ 
	session.setAttribute("MEMBERID", id); %>
	로그인에 성공하셨습니다
	<%} else { %>
	<script>
	alert("로그인에 실패하셨습니다");
	history.go(-1);
	</script>	
	<% } %>
</body>
</html>