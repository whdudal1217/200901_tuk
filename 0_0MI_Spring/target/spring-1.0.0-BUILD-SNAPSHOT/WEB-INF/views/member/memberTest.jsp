<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> MemberTest </title>
</head>
<body>
	<table>
		<tr>
			<td> 아이디 </td>
			<td> 이름 </td>
			<td> 이메일 </td>
		</tr>
		<c:forEach items="${memberList}" var="member">
			<tr>
				<td>${member.mem_id }</td>
				<td>${member.mem_name }</td>
				<td>${member.mem_email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>