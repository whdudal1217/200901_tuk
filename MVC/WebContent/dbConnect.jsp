<%@page import="java.sql.SQLException"%>
<%@page import="kr.ac.hit.common.jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> db연결 테스트 </title>
</head>
<body>
	<%
		try(Connection conn = ConnectionProvider.getConnection()){
			out.println("연결성공");
		}catch(SQLException e){
			out.println("연결실패" + e.getMessage());
			application.log("연결실패", e);
		}
	%>
</body>
</html>