<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8"); //이거 지정해주지 않으면 받을 때 한글이 깨져서 나옴
	String id = request.getParameter("member_id");
	String name = request.getParameter("member_name");
	String tel = request.getParameter("member_tel");
	String email = request.getParameter("member_email");
	String add = request.getParameter("member_add");
	%>
	<table>
	<tr><th>회원가입을 환영합니다</th></tr>
	<tr><td>id : <%=id%></td></tr>
	<tr><td>name : <%=name%></td></tr>
	<tr><td>tel : <%=tel%></td></tr>
	<tr><td>email : <%=email%></td></tr>
	<tr><td>add : <%=add%></td></tr>		
	</table>
</body>
</html>