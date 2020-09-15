<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	public int add(int a, int b){
		int c = a + b;
		return c;
	}
	public int substract(int a, int b){
		int c = a - b;
		return c;
	}
%>
</head>
<body>
<%
	int val1 = 3;
	int val2 = 9;
	int addResult =  add(val1, val2);
	int subsResult =  substract(val1, val2);
%>
<%=val1%> + <%=val2 %> = <%= addResult %>
<%=val1%> - <%=val2 %> = <%= subsResult %>
</body>
</html>