<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">


	$(document).ready(function(){
		alert("로그인 해주세요!")
		$("#mem_id").focus();
		$("#mem_pwd").keydown(function(key) { //키를 눌렀을때 keydown
			if(key.keyCode == 13){ //엔터키를 눌렀을때
				login();
			}
		});
	});
	
	
	function login(){
		alert("로그인중")
		var frm = document.loginForm;
		if(!validate()){
			return false;
		}
		frm.action="loginForm"
		frm.submit();
	}
	
	function validate() {
		var frm = document.loginForm;
		if(frm.mem_id.value == ''){
			alert("이름을 입력하세요");
			return false;
		}
		if(frm.mem_pwd.value == ''){
			alert("패스워드를 입력하세요");
		}
		return true;
	}
</script>
</head>
<body>
	<div id="container" align="center" >
		<h3> 로그인 </h3>
		<form action="loginForm" name="loginForm" method="post">
			<table class="table table-bordered" style="width: 300px">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mem_id" id="mem_id" size="20"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="mem_pwd" id="mem_pwd" size="20"></td>
				</tr>
				<tr>
					<td>
						<input type="button" class="btn btn-default" value="로그인" onclick="login();">
					</td>
					<td>
						<input type="button" class="btn btn-default" value="회원가입" 
						onclick="location.href='${pageContext.request.contextPath}/member/memberForm'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>