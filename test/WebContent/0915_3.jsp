<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 선언부를 사용한 두 정수값의 곱 0915_3</title>
<%!
	public int multiply(int a, int b){
		int c = a + b;
		return c;
	}
%>
</head>
<body>
10 * 25 = <%= multiply(10, 20)%>
</body>
</html>