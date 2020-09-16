<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 성공시 여기로 -->
<%
String id = request.getParameter("id");
%>
<%= id %>님 환영합니다!
</body>
</html>