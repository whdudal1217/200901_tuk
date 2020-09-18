<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- sessionLogin,jsp -->
	<form action="<%= request.getContextPath() %>/sessionLogin.jsp" method="post">
		아이디 : <input type="text" name="id" size="10">
		암호 : <input type="password" name="pwd" size="10">
		<input type="submit" value="로그인">
	</form>
</body>
</html>