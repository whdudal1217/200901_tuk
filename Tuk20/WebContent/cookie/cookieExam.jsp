<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.hit.utils.Cookies" %>
<%
	response.addCookie(Cookies.createCookie("name", "고길동"));
	response.addCookie(Cookies.createCookie("id", "madvirus","/chap09",-1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> Cookies 사용 예</title>
</head>
<body>
Cookies를 사용하여 쿠키 생성
</body>
</html>