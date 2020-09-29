<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${hello}<br/>
<%= request.getAttribute("hello") %><br/>
<%= request.getParameter("cmd") %><br /> 
</body>
</html>