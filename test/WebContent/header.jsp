<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 메소드 사용해보기</title>
</head>
<body>
<% 
Enumeration headEnum = request.getHeaderNames();
while(headEnum.hasMoreElements()){
	String headerName = (String)headEnum.nextElement();
	String headerValue = request.getHeader(headerName);
%>
<%= headerName %> = <%= headerValue %> <br>
<% 
}
%>
</body>
</html>