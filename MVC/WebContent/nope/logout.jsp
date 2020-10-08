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
<%
	request.setCharacterEncoding("UTF-8");
	String message = null;
	System.out.println ("로그아웃 전 : " + session.getAttribute("LOGIN_USER"));
	if(session.getAttribute("LOGIN_USER") != null){
		session.removeAttribute("LOGIN_USER");
	}
	System.out.println ("로그아웃 후 : " + session.getAttribute("LOGIN_USER"));
%>
<c:if test="${empty sessionScope.LOGIN_USER}">
	<script type="text/javascript">
		alert("로그아웃 되었습니다");
		location.href="loginForm.do";
	</script>
</c:if>
</body>
</html>