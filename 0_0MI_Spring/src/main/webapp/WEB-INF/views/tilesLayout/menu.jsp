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
			<li ><a href="${pageContext.request.contextPath}/member/memberList" > 회원관리 </a></li>
			<li ><a href="#">게시판</a></li>
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
		</ul>
		<c:if test="${sessionScope.LOGIN_USER == null}">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/login/loginForm">LOGIN</a></li>
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