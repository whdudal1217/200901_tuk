<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- loginform 성공시 여기로 와서 리다이렉트로 로그인석세스로 가면 됨 -->
<%

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
System.out.println("loginCk ID : " + id + "    loginCk PWD : " + pwd);
if( id != null && pwd != null){
		if( id.equals("11") && pwd.equals("11") ) {
			response.sendRedirect("loginSuccess.jsp?id="+id); 
		}else{
			response.sendRedirect("memberForm.jsp");
		}
}
%>

</body>
</html>