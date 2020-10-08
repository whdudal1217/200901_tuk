<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript">
	function login(){
		var frm = document.loginForm;
		if(frm.mem_id.value== ""){
			alert("아이디 입력 해주세요");
			return false;
		}
		if(frm.mem_pwd.value== ""){
			alert("비밀번호 입력 해주세요");
			return false;
		}
		frm.action="${pageContext.request.contextPath}/login/login.do"
		frm.submit();
	}
</script>
</head>
<body>
<div >
</div>
	<div align="center" style=" position:absolute; top:40%; left:40%;">
		<form action="loginForm" name="loginForm" method="post">
			<table class="table table-bordered" style="width: 300px">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id" size="20"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="mem_pwd" size="20"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" class="btn btn-default" value="로그인" onclick="login();">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>