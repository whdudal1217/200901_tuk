<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.hit.utils.Cookies" %>
<%
	response.addCookie(Cookies.createCookie("name", "��浿"));
	response.addCookie(Cookies.createCookie("id", "madvirus","/chap09",-1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> Cookies ��� ��</title>
</head>
<body>
Cookies�� ����Ͽ� ��Ű ����
</body>
</html>