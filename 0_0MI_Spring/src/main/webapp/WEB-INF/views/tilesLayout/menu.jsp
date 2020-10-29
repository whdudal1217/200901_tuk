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
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li > <a href="${pageContext.request.contextPath}/" > Home </a> </li>
			<c:if test="${sessionScope.LOGIN_USER.mem_type != 'A'}">
				<li ><a href="#" onclick="alert('괸리자만 볼 수 있는 페이지입니다!'); window.location.reload()" > 회원관리 </a></li>			
			</c:if>
			<c:if test="${sessionScope.LOGIN_USER.mem_type == 'A'}">
				<li ><a href="${pageContext.request.contextPath}/member/memberList" > 회원관리 </a></li>			
			</c:if>
			<li ><a href="${pageContext.request.contextPath}/board/boardList?bo_type=BBS">게시판</a></li>
			<li ><a href="${pageContext.request.contextPath}/board/galleryList?bo_type=GALLERY">갤러리</a></li>
			<li ><a href="#">자료실</a></li>
			<li>
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					Hello
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">drop1</a></li>
					<li><a href="#">drop2</a></li>
				</ul>
			</li>
				<li><a href="${pageContext.request.contextPath}/board/noticeList?bo_type=Notice">공지사항</a></li>
		</ul>
		<c:if test="${sessionScope.LOGIN_USER == null}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/login/loginForm">LOGIN</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/member/memberForm">JOIN</a></li>
			</ul>
		</c:if>
		<c:if test="${sessionScope.LOGIN_USER != null}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/login/logOut">LOGOUT</a></li>
			</ul>
		</c:if>
	</div>
</body>
</html>