<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원목록 </title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script>
	
	function goViewPage(seqNo){
		location.href="memberView.do?seqNo="+seqNo;
	}
	
	function doSearch(){
		var frm = document.searchForm;
		if(frm.searchType.value != "" && frm.searchWord.value == "" ){
			alert("검색어를 입력해주세요");
			return false;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<div class="container">
		<h2 align="center">회원목록</h2>
		<!-- 검색 -->
		<form action="memberList.do" method="post" name="searchForm">
			<select name="searchType">
				<option value="">전체</option>
				<option ${param.searchType == 'id' ? 'selected' : '' } value="id">아이디</option>
				<option ${param.searchType == 'name' ? 'selected' : '' } value="name">이름</option>
			</select> 
			<input type="text" size="20" name="searchWord" value="${param.searchWord}"> 
			<input type="button" value="검색" onclick="doSearch()">
		</form>
		<!-- /검색 -->
		<p align="right">
			<c:if test="${empty sessionScope.LOGIN_USER}">
				<input type="button" value="로그인" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/login/loginForm.do'">				
			</c:if>
			<c:if test="${not empty sessionScope.LOGIN_USER}">
				<input type="button" value="로그아웃" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/login/logout.do'">				
			</c:if>
			<input type="button" value="회원가입" class="btn btn-default" onclick="location.href='memberForm.do'">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>핸드폰</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty memberList}">
				<c:forEach var="member" items="${memberList}">
				<c:url var="viewURL" value="memberView.do">
					<c:param name="seqNo" value="${member.mem_seq_no}" />
				</c:url>
				<tr onclick="goViewPage(${member.mem_seq_no})">
					<td>${member.mem_seq_no}</td>
					<td>${member.mem_id}</td>
					<td><a href="${viewURL}" >${member.mem_name}</a></td>
					<td>${member.mem_phone}</td>
					<td>${member.mem_email}</td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${empty memberList}">
					<td colspan="5"> 데이터가 존재하지 않습니다. </td>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>
