<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.setAttribute("MEMBERID", "고길동");
	session.setAttribute("NAME", "go");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
세션에 정보를 저장하였습니다. <br>
MEMBERID : <%= session.getAttribute("MEMBERID") %> <BR>
NAME : <%= session.getAttribute("NAME") %>
</body>
</html>