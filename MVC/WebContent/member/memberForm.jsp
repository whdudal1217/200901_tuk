<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
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
	<div class="container">
		<c:if test="${not empty member.mem_id }">
			<h2 align="center">회원수정</h2>
		</c:if>
		<c:if test="${empty member.mem_id }">
			<h2 align="center">회원가입</h2>
		</c:if>
		<form name="memberForm" method="post">
			<input type="hidden" name="mem_seq_no" value="${member.mem_seq_no}">
			<table class="table table-bordered">
				<tr>
					<td> 성명 </td>
					<td> <input type="text" name="mem_name" size="20" value="${member.mem_name}"> 실명을 입력해주세요 </td>
				</tr>
				<tr>
					<td> 아이디 </td>
					<td> 
						<input type="text" name="mem_id" size="20" value="${member.mem_id}"> 
						<button type="button" class="btn btn-default"> ID 중복 검사 </button> 8~20자리 숫자와 영문으로 입력해주세요.
					</td>
				</tr>
				<tr>
					<td> 비밀번호 </td>
					<td> <input type="password" name="mem_pwd" size="20" > </td>
				</tr>
				<tr>
					<td> 비밀번호확인 </td>
					<td> <input type="password" name="mem_pwd_ck" size="20"> </td>
				</tr>
				<tr>
					<td> 생년월일 </td>
					<td> <input type="text" name="mem_birth" size="20" value="${member.mem_birth}"> </td>
				</tr>
				<tr>
					<td> 성별 </td>
					<td> <input type="text" name="mem_type" size="20" value="${member.mem_type}"> </td>
				</tr>
				<tr>
					<td> 전화번호 </td>
					<td> <input type="text" name="mem_phone" size="20" value="${member.mem_phone}"> </td>
				</tr>
				<tr>
					<td> 이메일 </td>
					<td> <input type="text" name="mem_email" size="20" value="${member.mem_email}"> </td>
				</tr>
				<tr>
					<td> 주소 </td>
					<td> 
						<p>
							<input type="text" name="mem_zipcode" size="20" value="${member.mem_zipcode}"> 
							<button type="button" class="btn btn-default"> 우편번호검색 </button>
						</p>
						<p> <input type="text" name="mem_addr_master" size="50" value="${member.mem_addr_master}"> </p>
						<p> <input type="text" name="mem_addr_detail" size="50" value="${member.mem_addr_detail}"> </p>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<c:if test="${empty member.mem_id}">
					<input type="button" value="가입하기" class="btn btn-default" onclick="doSubmit(1)">					
					</c:if>
					<c:if test="${not empty member.mem_id}">
					<input type="button" value="수정하기" class="btn btn-default" onclick="doSubmit(2)">					
					</c:if>
					<input type="reset" value="취소" class="btn btn-default">
					<input type="button" value="목록" class="btn btn-default" onclick="location.href='memberList.do'">
				</tr>
			</table>
		</form>
	</div>
</body>
</html>