<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<%
	Enumeration<String> initParamEnum = application.getInitParameterNames(); //반복가능한 객체 Enumeration<T>, 파람이 여러개일 수도 있으니까
	while(initParamEnum.hasMoreElements()){ //객체가 여러개면 hasMoreElements(), length는 배열,어레이배열 이런것들만 가능)
		String initParamName = initParamEnum.nextElement(); //파람을 있는 대로 다 initParamName에 넣어서
	
%>
<li> <%= initParamName %> = <%= application.getInitParameter(initParamName) %> <!-- 넣는 즉시즉시 실행, 파람네임으로 가져오면 밸류가 가져와진다 -->
<% } %>
</ul>
</body>
</html>