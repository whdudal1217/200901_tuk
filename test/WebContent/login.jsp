<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<%
	String id = request.getParameter("memberId");
	if(id!=null && id.equals("가나")){
		response.sendRedirect("/test/index.jsp");
	}else{
%> 
<html>
<head><meta charset="UTF-8"><title>로그인 실패</title></head>
<body>
잘못된 아이디입니다
</body>
</html>
<%
	}
%>
</body>
</html>