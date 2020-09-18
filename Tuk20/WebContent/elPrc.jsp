<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("name", "고길동");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Object</title>
</head>
<body>
	요청 URI : ${pageContext.request.requestURI}<br>
	request의 name 속성 : ${requestScope.name}<br>
	request의 id 속성 : ${requestScope.id}<br> 
	code 파라미터 : ${param.code}<br>
	memberId 파라미터 : ${empty param.memId}<br>
	<%-- <% if(${empty param.memId}){%>
	<% } %> --%>
</body>
</html>