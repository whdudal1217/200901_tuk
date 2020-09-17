<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/Tuk20/processJoin.jsp" method="post">
<table border="1">
	<tr>
		<td>아이디</td>
		<td colspan="3"> <input type="text" name="id" size="10"> </td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" size="10"></td>
		<td>이메일</td>
		<td><input type="text" name="e-mail" size="10"></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="회원가입">
		</td>
	</tr>
</table>
</form>
</body>
</html>