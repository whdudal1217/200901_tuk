<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function validateCheck(){
	var mf = document.memberForm;
	if(mf.member_id.value==""){
		alert(" id를 입력해주세요");
		document.memberForm.member_id.focus();
		return false;
	}
	if(mf.member_name.value==""){
		alert(" 이름을 입력해주세요");
		document.memberForm.member_name.focus();
		return false;
	}
	if(mf.member_pwd.value==""){
		alert(" 비밀번호를 입력해주세요");
		document.memberForm.member_pwd.focus();
		return false;
	}else if(mf.member_pwd.value != mf.member_pwdCk.value){
		alert(" 비밀번호와 비밀번호체크의 값이 같지 않습니다");
		document.memberForm.member_pwdCk.focus();
		return false;
	}
	if(mf.member_tel.value==""){
		alert(" 전화번호를 입력해주세요");
		document.memberForm.member_tel.focus();
		return false;
	}
	if(mf.member_email.value==""){
		alert(" 이메일을 입력해주세요");
		document.memberForm.member_email.focus();
		return false;
	}
	if(mf.member_add.value==""){
		alert(" 주소를 입력해주세요");
		document.memberForm.member_add.focus();
		return false;
	}
	return true;
}
</script>
<body>
	<form action="memberView.jsp" method="post"
		onsubmit="return validateCheck()" name="memberForm">
		<table>
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member_id"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="member_pwd"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="text" name="member_pwdCk"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="member_tel"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="member_email"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="member_add"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>