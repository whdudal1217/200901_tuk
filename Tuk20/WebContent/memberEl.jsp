<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberEl.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Member member = new Member("홍길동", 24);
request.setAttribute("member", member);
%>
\${member.getName()} : ${member.getName()}
\${member.getAge()} : ${member.getAge()}
</body>
</html>