<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p></p>
<div class="container">
	<h2 align="center"> 게시글 상세보기 </h2>
	<table class="table">
		<c:choose>
			<c:when test="${board.bo_open_yn =='Y' ||(not empty sessionScope.LOGIN_USER && sessionScope.LOGIN_USER.mem_id == board.bo_writer)}">
			<tr>
				<td>제목</td>
				<td>${board.bo_title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.bo_writer}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.reg_date}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${board.bo_hit_cnt}</td>
			</tr>
			<tr>
				<td>공개여부</td>
				<td> ${board.bo_open_yn == 'Y' ? '공개' : '비공개' } </td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.bo_content}</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2">비밀글입니다</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<p align="center">
		<c:if test="${not empty sessionScope.LOGIN_USER || sessionScope.LOGIN_USER.mem_id == board.bo_writer}">
			<input type="button" value="수정" class="btn btn-primary" id="btnEdit">
			<input type="button" value="삭제" class="btn btn-primary" id="btnEdit">
		</c:if>
		<input type="button" value="목록" class="btn btn-primary" onclick="history.go(-1)">
	</p>
</div>
</body>
</html>