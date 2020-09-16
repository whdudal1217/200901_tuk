<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> out 객체를 이용한 출력 </title>
</head>
<body>
<br>
out 기본 객체를 사용하여
<% out.println("-출력한 결과입니다-"); %>
<br>
<% 
	int grade = 20;
	String gradeStringA = "A";
	String gradeStringB = "B";
	if(grade > 10){
		out.println(gradeStringA);
	}else{
		out.println(gradeStringB);
	}
%>
</body>
</html>