<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/error/viewErrorMessage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 일부러 오류 -->
<!-- null오류 -->
<%-- name 파라미터 값 : <%= request.getParameter("name").toUpperCase() %> --%>

<!-- 404오류 -->
<%-- <% response.sendRedirect("1.jsp"); %> --%> 

<!-- 500오류 -->
<% int var = 500/0; %>
</body>
</html>