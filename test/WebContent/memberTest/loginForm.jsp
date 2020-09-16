<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function validateCheck(){
	if(document.loginForm.id.value==""){
		alert(" id를 입력해주세요");
		document.loginForm.id.focus();
		return false;
	}
	if(document.loginForm.pwd.value==""){
		alert(" pwd를 입력해주세요");
		document.loginForm.pwd.focus();
		return false;
	}
	
}
//선생님 방법
function validate(){
	if(document.loginForm.id.value=="" && document.loginForm.id.value == null){
		alert(" id를 입력해주세요");
		document.loginForm.id.focus();
		return false;
	}
	if(document.loginForm.pwd.value==""){
		alert(" pwd를 입력해주세요");
		document.loginForm.pwd.focus();
		return false;
	}
	return true
}
function login(){
	validate();
	frm.action="loginCk.jsp"
	frm.submit
}
</script>
</head>
<body>
		<form action="loginCk.jsp" method="post" onsubmit="return validateCheck()" name="loginForm">
				<table>
					<tr>
						<th colspan="2">로그인</th>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="로그인" onclick=""></td>
					</tr>
				</table>
			</form>
</body>
</html>