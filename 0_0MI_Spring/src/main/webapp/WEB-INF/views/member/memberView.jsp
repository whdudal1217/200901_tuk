<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function doSubmit(type){
	var frm = document.memberForm;
	if(!validate()){
		return false;
	}
	if(type==1){
		frm.action="memberInsert.do";
	}
	if(type==2){
		frm.action="memberUpdate.do";
	}
	frm.submit();
}

function validate(){
	var frm = document.memberForm;
	if(frm.mem_name.value ==""){
		alert("이름을 입력해주세요.");
		frm.mem_name.focus();
		return false;
	}
	if(frm.mem_id.value ==""){
		alert("아이디를 입력해주세요.");
		frm.mem_id.focus();
		return false;
	}
	if(frm.mem_pwd.value ==""){
		alert("패스워드를 입력해주세요.");
		frm.mem_pwd.focus();
		return false;
	}else{
		if(frm.mem_pwd_ck.value == ""){
			alert("비밀번호 확인을 입력해주세요.");
			return false;
		}else{
			if(frm.mem_pwd.value != frm.mem_pwd_ck.value){
				alert("비밀번호와 비밀번호 확인이 맞지 않습니다.");
				return false;
			}
		}
	}
	if(frm.mem_birth.value ==""){
		alert("생일 입력해주세요.");
		frm.mem_birth.focus();
		return false;
	}
	if(frm.mem_phone.value ==""){
		alert("전화번호를 입력해주세요.");
		frm.mem_phone.focus();
		return false;
	}
	if(frm.mem_email.value ==""){
		alert("이메일을 입력해주세요.");
		frm.mem_email.focus();
		return false;
	}
	return true;
	
}
</script>
</head>
<body>
<p></p>
<div class="container">
	<table class="table table-bordered table-hover">
		<tr>
			<td>이름</td>
			<td>${member.mem_name}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.mem_id}</td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td>${member.mem_phone}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${member.mem_email}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${member.mem_birth}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<p>${member.mem_zipcode}</p>
				<p>${member.mem_addr_master}</p>
				<p>${member.mem_addr_detail}</p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" class="btn btn-default"; onclick="location.href='memberForm?seqNo=${member.mem_seq_no}'";>
				<input type="button" value="삭제" class="btn btn-default"; onclick="location.href='memberDelete?seqNo=${member.mem_seq_no}'";>
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='memberList?currentPage=${currentPage}'";>
			</td>
		</tr>
	</table>
</div>
</body>
</html>