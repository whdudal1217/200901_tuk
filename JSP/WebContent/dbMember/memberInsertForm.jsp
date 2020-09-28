<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberInsert.jsp">
		<table>
			<tr>
				<td> 아이디 </td><td><input type="text" name="memberId" size="10"></td>
			</tr>
			<tr>
				<td> 비밀번호 </td><td><input type="text" name="memberPwd" size="10"></td>
			</tr>
			<tr>
				<td> 이름 </td><td><input type="text" name="memberName" size="10"></td>
			</tr>
			<tr>
				<td> 이메일 </td><td><input type="text" name="memberEmail" size="10"></td>
			</tr>
			<tr>
				<td> <input type="submit" value="추가"> </td>
			</tr>
		</table>	
	</form>
</body>
</html>