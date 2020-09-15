<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title> 더하기 0915_1 </title>
</head>
<body>
<%
	int sum = 0;
	for(int i = 0; i<=10; i++){
		sum+=i;
	}
%>
 썸 값은 <%= sum %>
 <br/>
 <%
	int sum2 = 0;
	for(int i = 0; i<=10; i++){
		sum2+=i;
	}
%>
 썸2 값은 <%= sum2 %>
</body>
</html>