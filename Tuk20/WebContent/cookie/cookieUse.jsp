<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.hit.utils.Cookies" %>
<%
	Cookies cookie = new Cookies(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
name 쿠키 = <%= cookie.getValue("name") %>
<% if(cookie.exists("id")){ %>
id 쿠키 = <%= cookie.getValue("id") %> <br>
<% } %>
</body>
</html>