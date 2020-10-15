<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<p></p>
<div class="container">
	<table class="table table-bordered table-hover">
		<tr>
			<td>이름</td>
			<td>${member.mem_name}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.mem_id}</td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td>${member.mem_phone}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${member.mem_email}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${member.mem_birth}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<p>${member.mem_zipcode}</p>
				<p>${member.mem_addr_master}</p>
				<p>${member.mem_addr_detail}</p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" class="btn btn-default";>
				<input type="button" value="삭제" class="btn btn-default";>
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='memberList?currentPage=${currentPage}'";>
			</td>
		</tr>
	</table>
</div>
</body>
</html>