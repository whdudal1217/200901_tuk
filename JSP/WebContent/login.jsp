<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
 String memberId = request.getParameter("memberId");
 session.setAttribute("MEMBER", memberId);
%>
<head>
<meta charset="UTF-8">
<title> 저장 </title>
</head>
<body>
로그인 성공
</body>
</html>