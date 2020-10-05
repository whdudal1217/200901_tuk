<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 폼 </title>
</head>
<body>
<form action="<%= request.getContextPath()%>/login.jsp">
아이디 : <input type="text" name="memberId">
비밀번호 : <input type="password" name="memberPwd">
<input type="submit" value="전송">
</form>
</body>
</html>