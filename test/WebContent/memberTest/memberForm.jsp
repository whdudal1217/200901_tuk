<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function validateCheck(){
	if(!document.memberForm.member_id.value){
		alert(" id를 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}
	if(!document.memberForm.member_name.value){
		alert(" 이름을 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}
	if(!document.memberForm.member_pwd.value){
		alert(" 비밀번호를 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}else if(document.memberForm.member_pwd.value != document.memberForm.member_pwdCk.value){
		alert(" 비밀번호와 비밀번호체크의 값이 같지 않습니다");
		return false;
	}
	if(!document.memberForm.member_tel.value){
		alert(" 전화번호를 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}
	if(!document.memberForm.member_id.value){
		alert(" 이메일을 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}
	if(!document.memberForm.member_id.value){
		alert(" 주소를 입력해주세요");
		document.memberForm.member_id.focus();
		retrun false;
	}
}
</script>
<body>
	<form action="memberView.jsp" method="post"
		onsubmit="return validateCheck()" id="memberForm">
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