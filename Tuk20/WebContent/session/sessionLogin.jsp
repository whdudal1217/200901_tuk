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
	�α��ο� �����ϼ̽��ϴ�
	<%} else { %>
	<script>
	alert("�α��ο� �����ϼ̽��ϴ�");
	history.go(-1);
	</script>	
	<% } %>
</body>
</html>