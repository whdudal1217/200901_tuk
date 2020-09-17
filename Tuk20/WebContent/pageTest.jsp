<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userName = "홍길동";
	int userAge = 25;
	Date date = new Date();
	
	request.setAttribute("userName_r", userName);
	request.setAttribute("userAge_r", userAge);
	request.setAttribute("date_r", date);
	
	session.setAttribute("userName_s", userName);
	session.setAttribute("userAge_s", userAge);
	session.setAttribute("date_s", date);
	
	application.setAttribute("userName_a", userName);
	application.setAttribute("userAge_a", userAge);
	application.setAttribute("date_a", date);
%>

<h3> request의 속성 정보</h3>
이름 : <%= request.getAttribute("userName_r") %>
나이 : <%= request.getAttribute("userAge_r") %>
날짜 : <%= request.getAttribute("date_r") %>

<% 
//request.removeAttribute("userName_r");
//request.setAttribute("userName_r", "");
%>
<h3> session의 속성 정보</h3>
이름 : <%= session.getAttribute("userName_s") %>
나이 : <%= session.getAttribute("userAge_s") %>
날짜 : <%= session.getAttribute("date_s") %>

<h3> application의 속성 정보</h3>
이름 : <%= application.getAttribute("userName_a") %>
나이 : <%= application.getAttribute("userAge_a") %>
날짜 : <%= application.getAttribute("date_a") %>

</body>
</html>