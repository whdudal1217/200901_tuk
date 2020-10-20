<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- tiles의 메인프레임에 css와 js를 넣어놓으면 다른 부가적인 jsp에선 다시 적지 않아도 됨 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src = "${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</head>
<body>
<div class="container">
	<div class="container">
		<tiles:insertAttribute name="header" />
	</div>
	<br />
	<div class="navbar navbar-default">
		<tiles:insertAttribute name="menu" />
	</div>
	<div class="container-fluid" style="min-height:400px;">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="container-fluid text-center" style="background-color: #555; color:white; padding: 15px;">
		<tiles:insertAttribute name="footer" />
	</div>
</div>
</body>
</html>