<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.setAttribute("MEMBERID", "��浿");
	session.setAttribute("NAME", "go");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
���ǿ� ������ �����Ͽ����ϴ�. <br>
MEMBERID : <%= session.getAttribute("MEMBERID") %> <BR>
NAME : <%= session.getAttribute("NAME") %>
</body>
</html>