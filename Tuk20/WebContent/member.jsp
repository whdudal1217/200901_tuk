<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="kr.ac.hit.member.MemberInfo"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	member.setId("Id01");
	member.setName("고길동");
%>
<jsp:forward page="/useBeanObject.jsp"/>
</body>
</html>